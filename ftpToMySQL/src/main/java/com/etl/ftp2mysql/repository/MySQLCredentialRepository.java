package com.etl.ftp2mysql.repository;

import com.etl.ftp2mysql.entity.MySQLCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySQLCredentialRepository  extends JpaRepository<MySQLCredential, Long> {
}
