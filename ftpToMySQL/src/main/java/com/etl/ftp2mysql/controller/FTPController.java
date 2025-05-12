package com.etl.ftp2mysql.controller;

import com.etl.ftp2mysql.payload.FTPRequest;
import com.etl.ftp2mysql.services.FTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ftp")
public class FTPController {

    @Autowired
    private FTPService ftpService;

    @PostMapping("/get-files")
    private ResponseEntity<?> getRawFiles( @RequestBody FTPRequest request){
        return ResponseEntity.ok(ftpService.getFilesFromFTP(request));
    }
}
