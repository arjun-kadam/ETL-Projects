package com.etl.ftp2mysql.services.impl;

import com.etl.ftp2mysql.entity.RawDataFetchLogs;
import com.etl.ftp2mysql.payload.RawDataLogsRequest;
import com.etl.ftp2mysql.repository.RawDataFetchLogsRepository;
import com.etl.ftp2mysql.services.RawDataFetchLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RawDataFetchLogsServiceImpl implements RawDataFetchLogsService {

    @Autowired
    private RawDataFetchLogsRepository rawDataFetchLogsRepository;

    @Override
    public void saveRawDataLogs(RawDataLogsRequest request) {
        RawDataFetchLogs rawDataFetchLogs=new RawDataFetchLogs();
        rawDataFetchLogs.setFileName(request.getFileName());
        rawDataFetchLogs.setFileSize(request.getFileSize());
        rawDataFetchLogs.setFetchStatus(request.getFetchStatus());
        rawDataFetchLogs.setFetchedAt(new Timestamp(System.currentTimeMillis()));
        rawDataFetchLogsRepository.save(rawDataFetchLogs);
    }
}
