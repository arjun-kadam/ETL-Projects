package com.etl.ftp2mysql.utilities;

import com.etl.ftp2mysql.payload.MySQLCredentialDTO;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DBPoolFactory {

    public static EntityManagerFactory createEntityManagerFactory(MySQLCredentialDTO cred){

        HikariDataSource hikariDataSource=new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:mysql://"+cred.getHost() + ":" +cred.getPort() + "/" + cred.getDatabaseName());
        hikariDataSource.setUsername(cred.getUserName());
        hikariDataSource.setPassword(cred.getPassword());
        hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        LocalContainerEntityManagerFactoryBean emfBean = getLocalContainerEntityManagerFactoryBean(hikariDataSource);

        return  emfBean.getObject();
    }

    private static LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(HikariDataSource hikariDataSource) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto", "none");

        LocalContainerEntityManagerFactoryBean emfBean=new LocalContainerEntityManagerFactoryBean();
        emfBean.setDataSource(hikariDataSource);
        emfBean.setPackagesToScan("com.etl.ftp2mysql.external.entity");
        emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfBean.setJpaPropertyMap(properties);
        emfBean.afterPropertiesSet();
        return emfBean;
    }
}
