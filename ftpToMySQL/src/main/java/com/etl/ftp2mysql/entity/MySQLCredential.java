package com.etl.ftp2mysql.entity;

import jakarta.persistence.*;

@Entity
@Table(name="mysql_credentials")
public class MySQLCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mySQLCredentialId;
    private String host;
    private Integer port;
    private String databaseName;
    private String userName;
    private String password;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public Long getMySQLCredentialId() {
        return mySQLCredentialId;
    }

    public void setMySQLCredentialId(Long mySQLCredentialId) {
        this.mySQLCredentialId = mySQLCredentialId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
