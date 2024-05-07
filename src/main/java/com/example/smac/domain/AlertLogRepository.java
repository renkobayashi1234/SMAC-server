package com.example.smac.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertLogRepository extends CrudRepository<AlertLogEntity,Integer>{
    
    List<AlertLogEntity> findByAlertNo(String alertNo);
    List<AlertLogEntity> findByStatus(int status);
    List<AlertLogEntity> findByNewest(int newest);
    List<AlertLogEntity> findAll();

    @Query(nativeQuery=true,
    value="select "+
    "ale.SQUNO,ale.ALERTBANGO,ale.KAYIJYOTANMATU,ale.KAYIJYONITIJI,ale.RISETOTANMATU,ale.RISETONITIJI,ale.HASEINITIJI,ale.SAYISINFURAGU,ale.TUTINITIJI,ale.KEYIHOUSUTETASU "+
    "from M_ALERT_LOG ale "+
    "where ale.KEYIHOUSUTETASU=0 or ale.KEYIHOUSUTETASU=1 "+
    "limit :maxRecord")
    List<AlertLogEntity> findByAlerting(@Param("maxRecord") int maxRecord);

    @Query(nativeQuery=true,
    value="select "+
    "ale.SQUNO,ale.ALERTBANGO,ale.KAYIJYOTANMATU,ale.KAYIJYONITIJI,ale.RISETOTANMATU,ale.RISETONITIJI,ale.HASEINITIJI,ale.SAYISINFURAGU,ale.TUTINITIJI,ale.KEYIHOUSUTETASU "+
    "from M_ALERT_LOG ale "+
    "where ale.KEYIHOUSUTETASU=2 "+
    "limit :maxRecord")
    List<AlertLogEntity> findByOngoing(@Param("maxRecord") int maxRecord);
}
