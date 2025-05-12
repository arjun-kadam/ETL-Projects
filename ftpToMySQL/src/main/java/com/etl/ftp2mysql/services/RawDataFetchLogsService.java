package com.etl.ftp2mysql.services;

import com.etl.ftp2mysql.payload.RawDataLogsRequest;

public interface RawDataFetchLogsService {
    void saveRawDataLogs(RawDataLogsRequest request);
}
