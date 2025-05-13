package com.etl.ftp2mysql.entity;

import com.etl.ftp2mysql.enums.DATA_PROCESSING_STATUS;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "data_processing_logs")
public class DataProcessingLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_processing_log_id")
    private Long dataProcessingLogId;

    private String fileName;

    private Integer fileSize;

    @Enumerated(value = EnumType.STRING)
    private DATA_PROCESSING_STATUS status;

    private Timestamp startAt;

    private Timestamp csvDoneAt;

    private Timestamp successAt;

    private Timestamp failedAt;

    public Timestamp getCsvDoneAt() {
        return csvDoneAt;
    }

    public void setCsvDoneAt(Timestamp csvDoneAt) {
        this.csvDoneAt = csvDoneAt;
    }

    public Long getDataProcessingLogId() {
        return dataProcessingLogId;
    }

    public void setDataProcessingLogId(Long dataProcessingLogId) {
        this.dataProcessingLogId = dataProcessingLogId;
    }

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

    public Timestamp getStartAt() {
        return startAt;
    }

    public void setStartAt(Timestamp startAt) {
        this.startAt = startAt;
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

    public DATA_PROCESSING_STATUS getStatus() {
        return status;
    }

    public void setStatus(DATA_PROCESSING_STATUS status) {
        this.status = status;
    }
}
