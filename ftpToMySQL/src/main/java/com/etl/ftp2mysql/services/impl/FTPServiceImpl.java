package com.etl.ftp2mysql.services.impl;

import com.etl.ftp2mysql.enums.RAW_FILE_FETCH_STATUS;
import com.etl.ftp2mysql.payload.FTPRequest;
import com.etl.ftp2mysql.payload.RawDataLogsRequest;
import com.etl.ftp2mysql.services.FTPService;
import com.etl.ftp2mysql.services.RawDataFetchLogsService;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class FTPServiceImpl implements FTPService {
    private static final String TEMP_FILE_STORE = "D://etl-test-data/ftp-temp";

    @Autowired
    private RawDataFetchLogsService rawDataFetchLogsService;

    @Override
    public int getFilesFromFTP(FTPRequest request) {
        FTPClient ftpClient = new FTPClient();
        RawDataLogsRequest rawDataLogsRequest;
        int count = 0;
        try {
            ftpClient.connect(request.getServerIp(), request.getPort());
            boolean loggedIn = ftpClient.login(request.getUsername(), request.getPassword());
            if (!loggedIn) {
                return 0;
            }

            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File tempDir = new File(TEMP_FILE_STORE);
            if (!tempDir.exists()) {
                tempDir.mkdirs();
            }

            FTPFile[] files = ftpClient.listFiles();

            for (FTPFile file : files) {
                if (!file.isFile()) {
                    continue;
                }

                String remoteFileName = file.getName();
                String localTempFile = TEMP_FILE_STORE + "/" + file.getName();

                boolean success = false;
                try (FileOutputStream fileOutputStream = new FileOutputStream(localTempFile)) {
                    success = ftpClient.retrieveFile(remoteFileName, fileOutputStream);
                }

                File downloadedFile = new File(localTempFile);

                if (success && downloadedFile.length() > 0) {
                    rawDataLogsRequest = new RawDataLogsRequest(file.getName(), downloadedFile.length(), RAW_FILE_FETCH_STATUS.SUCCESS);
                    rawDataFetchLogsService.saveRawDataLogs(rawDataLogsRequest);
                    count++;
                } else {
                    if (downloadedFile.exists()) {
                        downloadedFile.delete();
                    }
                    rawDataLogsRequest = new RawDataLogsRequest(file.getName(), 0L, RAW_FILE_FETCH_STATUS.FAIL);
                    rawDataFetchLogsService.saveRawDataLogs(rawDataLogsRequest);
                }
            }

            ftpClient.logout();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}