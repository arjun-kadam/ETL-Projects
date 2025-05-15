package com.etl.ftp2mysql.services.impl;

import com.etl.ftp2mysql.external.dto.ProductRequest;
import com.etl.ftp2mysql.external.entity.Product;
import com.etl.ftp2mysql.external.mapper.ProductMapper;
import com.etl.ftp2mysql.payload.MySQLCredentialDTO;
import com.etl.ftp2mysql.repository.DataProcessingLogRepository;
import com.etl.ftp2mysql.repository.MySQLCredentialRepository;
import com.etl.ftp2mysql.services.DataPersistenceWorkerService;
import com.etl.ftp2mysql.services.DataProcessingLogService;
import com.etl.ftp2mysql.utilities.DBPoolFactory;
import com.etl.ftp2mysql.utilities.MySQLCredentialHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataPersistenceWorkerServiceImpl implements DataPersistenceWorkerService {

    @Autowired
    private DataProcessingLogRepository dataProcessingLogRepository;

    @Autowired
    private DataProcessingLogService dataProcessingLogService;

    @Autowired
    private MySQLCredentialRepository mySQLCredentialRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void persistDataToExternalMySQLClient(List<ProductRequest> productRequests) {

        MySQLCredentialDTO mySQLCredentials= MySQLCredentialHelper.getMySQLCredentials(1L,mySQLCredentialRepository);

        // get Product DTO from File --
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = DBPoolFactory.createEntityManagerFactory(mySQLCredentials);
            em=emf.createEntityManager();
            EntityTransaction tx= em.getTransaction();
            tx.begin();
            int batchSize=50;
            for (int i=0; i<productRequests.size();i++){
                Product product=productMapper.toEntity(productRequests.get(i));
                em.persist(product);
                if (i > 0 && i % batchSize == 0){
                    em.flush();
                    em.clear();
                }
            }
            tx.commit();
        }catch (Exception e){
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
