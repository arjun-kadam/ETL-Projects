package com.etl.ftp2mysql.services.impl;

import com.etl.ftp2mysql.repository.DataProcessingLogRepository;
import com.etl.ftp2mysql.services.DataPersistenceWorkerService;
import com.etl.ftp2mysql.services.DataProcessingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataPersistenceWorkerServiceImpl implements DataPersistenceWorkerService {

    @Autowired
    private DataProcessingLogRepository dataProcessingLogRepository;

    @Autowired
    private DataProcessingLogService dataProcessingLogService;

    @Override
    public void persistDataToExternalMySQLClient() {

    }
}
