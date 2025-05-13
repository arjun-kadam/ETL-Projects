package com.etl.ftp2mysql.services;

import com.etl.ftp2mysql.enums.DATA_PROCESSING_STATUS;
import com.etl.ftp2mysql.payload.DataProcessingLogRequest;

public interface DataProcessingLogService {
    public Long insertDataLog(DataProcessingLogRequest request);
    public void updateDataLog(Long dataLogId, DATA_PROCESSING_STATUS status);
}
