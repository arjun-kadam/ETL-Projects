package com.etl.ftp2mysql.services;

import com.etl.ftp2mysql.external.dto.ProductRequest;

import java.util.List;

public interface DataPersistenceWorkerService {
    public void persistDataToExternalMySQLClient(List<ProductRequest> productRequests);
}
