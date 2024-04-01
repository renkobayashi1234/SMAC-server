package com.example.smac.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smac.domain.AlertLogEntity;
import com.example.smac.domain.AlertLogRepository;

@Service
public class PostAlertingInfoService {
    @Autowired
    AlertLogRepository alertLogRepository;

    public String post(String alertNo){
        setZeroNewest();

        AlertLogEntity log = new AlertLogEntity();
        log.setAlertNo(alertNo);
        log.setFireDate(LocalDateTime.now());
        log.setStatus(0);
        log.setNewest(1);

        try{
            alertLogRepository.save(log);
            return "1";
        }catch(Exception e){
            e.printStackTrace();
            return "0";
        }
    }

    public void setZeroNewest(){
        List<AlertLogEntity> newestList = alertLogRepository.findByNewest(1);
        for(AlertLogEntity newest:newestList){
            newest.setNewest(0);
        }
        alertLogRepository.saveAll(newestList);
    }
}
