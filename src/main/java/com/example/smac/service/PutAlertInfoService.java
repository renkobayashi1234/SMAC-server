package com.example.smac.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smac.domain.AlertLogEntity;
import com.example.smac.domain.AlertLogRepository;

@Service
public class PutAlertInfoService {
    @Autowired
    AlertLogRepository alertLogRepository;

    public String callOff(String alertNo,String address){

        try{
            List<AlertLogEntity> list=alertLogRepository.findByAlertNo(alertNo);
            List<AlertLogEntity> updatedList=new ArrayList<>();
            for(AlertLogEntity log:list){
                if(log.getStatus()==1){
                    log.setStatus(2);
                    log.setCallOffDate(LocalDateTime.now());
                    log.setCallOffAddress(address);
                    updatedList.add(log);
                }
            }
            alertLogRepository.saveAll(updatedList);

            return "OK";
        }catch(Exception e){
            return "NO";
        }
    }

    public String done(String alertNo,String address){

        try{
            List<AlertLogEntity> list=alertLogRepository.findByAlertNo(alertNo);
            List<AlertLogEntity> updatedList=new ArrayList<>();
            for(AlertLogEntity log:list){
                if(log.getStatus()==2){
                    log.setStatus(3);
                    log.setDoneDate(LocalDateTime.now());
                    log.setDoneAddress(address);
                    updatedList.add(log);
                }
            }

            alertLogRepository.saveAll(updatedList);

            return "OK";
        }catch(Exception e){
            return "NO";
        }
    }

    public String doneAll(String address){

        try{
            List<AlertLogEntity> list=alertLogRepository.findByStatus(2);
            List<AlertLogEntity> updatedList=new ArrayList<>();
            for(AlertLogEntity log:list){
                log.setStatus(3);
                log.setDoneDate(LocalDateTime.now());
                log.setDoneAddress(address);
                updatedList.add(log);
            }
            alertLogRepository.saveAll(updatedList);

            return "OK";
        }catch(Exception e){
            return "NO";
        }
    }


}
