package com.example.smac.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertLogRepository extends CrudRepository<AlertLogEntity,Integer>{
    List<AlertLogEntity> findByAlertNo(String alertNo);
    List<AlertLogEntity> findByStatus(int status);
    List<AlertLogEntity> findByNewest(int newest);
    List<AlertLogEntity> findAll();
}
