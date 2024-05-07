package com.example.smac.domain;

import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.smac.web.SmacController;

public class AlertInfoEntity {

    
    static Logger logger = LoggerFactory.getLogger(SmacController.class);

    private int id;
    private int alertNo;
    private String datetime;
    
    public AlertInfoEntity(int id, int alertNo, String datetime) {
        this.id = id;
        this.alertNo = alertNo;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlertNo() {
        return alertNo;
    }

    public void setAlertNo(int alertNo) {
        this.alertNo = alertNo;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public static AlertInfoEntity makeFromLog(AlertLogEntity log){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return new AlertInfoEntity(
            log.getId(), 
            Integer.parseInt(log.getAlertNo()), 
            log.getFireDate().format(formatter)
            );
    }
}
