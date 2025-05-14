package com.etl.ftp2mysql.utilities;

import com.etl.ftp2mysql.entity.MySQLCredential;
import com.etl.ftp2mysql.payload.MySQLCredentialDTO;
import com.etl.ftp2mysql.repository.MySQLCredentialRepository;

public class MySQLCredentialHelper {
    private MySQLCredentialHelper() {
    }

    public static MySQLCredentialDTO getMySQLCredentials(Long id, MySQLCredentialRepository repo) {
        MySQLCredential mySQLCredential = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Credentials not found"));

        MySQLCredentialDTO dto = new MySQLCredentialDTO();
        dto.setHost(mySQLCredential.getHost());
        dto.setDatabaseName(mySQLCredential.getDatabaseName());
        dto.setUserName(mySQLCredential.getUserName());
        dto.setPassword(mySQLCredential.getPassword());
        dto.setPort(mySQLCredential.getPort());
        return dto;
    }
}
