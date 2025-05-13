package com.etl.ftp2mysql.services.impl;

import com.etl.ftp2mysql.entity.DataProcessingLogs;
import com.etl.ftp2mysql.enums.DATA_PROCESSING_STATUS;
import com.etl.ftp2mysql.payload.DataProcessingLogRequest;
import com.etl.ftp2mysql.repository.DataProcessingLogRepository;
import com.etl.ftp2mysql.services.DataProcessingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class DataProcessingLogServiceImpl implements DataProcessingLogService {

    @Autowired
    private DataProcessingLogRepository dataProcessingLogRepository;

    @Override
    public Long insertDataLog(DataProcessingLogRequest request) {
        DataProcessingLogs dataProcessingLogs=new DataProcessingLogs();
        dataProcessingLogs.setFileName(request.getFileName());
        dataProcessingLogs.setFileSize(request.getFileSize());
        dataProcessingLogs.setStartAt(new Timestamp(System.currentTimeMillis()));
        dataProcessingLogs.setStatus(DATA_PROCESSING_STATUS.PENDING);
        DataProcessingLogs savedData=dataProcessingLogRepository.save(dataProcessingLogs);
        return savedData.getDataProcessingLogId();
    }

    @Override
    public void updateDataLog(Long dataLogId, DATA_PROCESSING_STATUS status) {
        DataProcessingLogs dataProcessingLogs=dataProcessingLogRepository.findById(dataLogId).orElseThrow(()->new RuntimeException("Invalid Data Processing Log"));
        if (status.equals(DATA_PROCESSING_STATUS.CLEANING)){
            dataProcessingLogs.setStatus(DATA_PROCESSING_STATUS.CLEANING);
            dataProcessingLogs.setCsvDoneAt(new Timestamp(System.currentTimeMillis()));
        } else if (status.equals(DATA_PROCESSING_STATUS.SUCCESS)) {
            dataProcessingLogs.setStatus(DATA_PROCESSING_STATUS.SUCCESS);
            dataProcessingLogs.setSuccessAt(new Timestamp(System.currentTimeMillis()));
        }else if (status.equals(DATA_PROCESSING_STATUS.FAILED)) {
            dataProcessingLogs.setStatus(DATA_PROCESSING_STATUS.FAILED);
            dataProcessingLogs.setFailedAt(new Timestamp(System.currentTimeMillis()));
        }else {
            throw new IllegalArgumentException("Illegal status provided");
        }
        dataProcessingLogRepository.save(dataProcessingLogs);
    }
}
