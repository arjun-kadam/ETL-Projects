package com.etl.ftp2mysql.repository;

import com.etl.ftp2mysql.entity.DataProcessingLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataProcessingLogRepository extends JpaRepository<DataProcessingLogs, Long> {
}
