package com.etl.ftp2mysql.repository;

import com.etl.ftp2mysql.entity.RawDataFetchLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawDataFetchLogsRepository extends JpaRepository<RawDataFetchLogs,Long> {
}
