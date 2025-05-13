package com.etl.ftp2mysql.payload;

import com.etl.ftp2mysql.enums.DATA_PROCESSING_STATUS;

import java.sql.Timestamp;

public class DataProcessingLogRequest {

    private String fileName;
    private Integer fileSize;
    private DATA_PROCESSING_STATUS status;
    private Timestamp startAt;
    private Timestamp csvDoneAt;
    private Timestamp successAt;
    private Timestamp failedAt;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public DATA_PROCESSING_STATUS getStatus() {
        return status;
    }

    public void setStatus(DATA_PROCESSING_STATUS status) {
        this.status = status;
    }

    public Timestamp getStartAt() {
        return startAt;
    }

    public void setStartAt(Timestamp startAt) {
        this.startAt = startAt;
    }

    public Timestamp getCsvDoneAt() {
        return csvDoneAt;
    }

    public void setCsvDoneAt(Timestamp csvDoneAt) {
        this.csvDoneAt = csvDoneAt;
    }

    public Timestamp getSuccessAt() {
        return successAt;
    }

    public void setSuccessAt(Timestamp successAt) {
        this.successAt = successAt;
    }

    public Timestamp getFailedAt() {
        return failedAt;
    }

    public void setFailedAt(Timestamp failedAt) {
        this.failedAt = failedAt;
    }
}
