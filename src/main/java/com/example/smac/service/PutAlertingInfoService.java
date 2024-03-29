package com.example.smac.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smac.domain.AlertLogEntity;
import com.example.smac.domain.AlertLogRepository;

@Service
public class PutAlertingInfoService {
    @Autowired
    AlertLogRepository alertLogRepository;

    public String put(String alertNo){
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
}
