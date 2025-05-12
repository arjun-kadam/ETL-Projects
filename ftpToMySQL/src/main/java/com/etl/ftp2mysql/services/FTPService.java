package com.etl.ftp2mysql.services;


import com.etl.ftp2mysql.payload.FTPRequest;

public interface FTPService {
    int getFilesFromFTP(FTPRequest ftpRequest);
}
