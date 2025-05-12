package com.etl.ftp2mysql.entity;

import com.etl.ftp2mysql.enums.RAW_FILE_FETCH_STATUS;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Entity
@Table(name = "raw_data_fetch_logs")
public class RawDataFetchLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raw_data_fetch_logs_id")
    private Long rawDataFetchLogId;

    private String fileName;

    private Long fileSize;

    @CreatedDate
    private Timestamp fetchedAt;

    public Long getRawDataFetchLogId() {
        return rawDataFetchLogId;
    }

    public void setRawDataFetchLogId(Long rawDataFetchLogId) {
        this.rawDataFetchLogId = rawDataFetchLogId;
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

    public Timestamp getFetchedAt() {
        return fetchedAt;
    }

    public void setFetchedAt(Timestamp fetchedAt) {
        this.fetchedAt = fetchedAt;
    }

    public RAW_FILE_FETCH_STATUS getFetchStatus() {
        return fetchStatus;
    }

    public void setFetchStatus(RAW_FILE_FETCH_STATUS fetchStatus) {
        this.fetchStatus = fetchStatus;
    }

    @Enumerated(value = EnumType.STRING)
    private RAW_FILE_FETCH_STATUS fetchStatus;
}
