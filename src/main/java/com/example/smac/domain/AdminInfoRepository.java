package com.example.smac.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AdminInfoRepository extends CrudRepository<AdminInfoEntity,String>{
    List<AdminInfoEntity> findByAlertNo(String alertNo);
}
