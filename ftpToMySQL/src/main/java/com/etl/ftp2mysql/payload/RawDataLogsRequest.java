package com.etl.ftp2mysql.payload;

import com.etl.ftp2mysql.enums.RAW_FILE_FETCH_STATUS;

public class RawDataLogsRequest {
    private String fileName;
    private Long fileSize;
    private RAW_FILE_FETCH_STATUS fetchStatus;

    public RawDataLogsRequest(String fileName, Long fileSize, RAW_FILE_FETCH_STATUS fetchStatus) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fetchStatus = fetchStatus;
    }

    public RawDataLogsRequest() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }


    public RAW_FILE_FETCH_STATUS getFetchStatus() {
        return fetchStatus;
    }

    public void setFetchStatus(RAW_FILE_FETCH_STATUS fetchStatus) {
        this.fetchStatus = fetchStatus;
    }
}
