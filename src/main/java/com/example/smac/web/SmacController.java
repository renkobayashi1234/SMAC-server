package com.example.smac.web;

import org.springframework.web.bind.annotation.RestController;
import com.example.smac.domain.AllAlertInfoEntity;
import com.example.smac.service.GetAlertInfoService;
import com.example.smac.service.PutAlertInfoService;
import com.example.smac.service.PostAlertingInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@RestController
@RequestMapping("/")
public class SmacController {

    Logger logger = LoggerFactory.getLogger(SmacController.class);

    @Autowired
    GetAlertInfoService getAlertInfoService;

    @Autowired
    PostAlertingInfoService postAlertingInfoService;

    @Autowired
    PutAlertInfoService putAlertInfoService;

    @CrossOrigin
    @GetMapping("/get")
    public AllAlertInfoEntity get(){
        return getAlertInfoService.getAlertInfo();
    }

    @CrossOrigin
    @PutMapping("/put/callOff")
    public String postAlertingInfo(@RequestParam(value = "alertNo", defaultValue = "0") String alertNo,
    @RequestParam(value = "address", defaultValue = "0") String address) {
        logger.info("put callOff!");
        
        return putAlertInfoService.callOff(alertNo,address);
    }

    @CrossOrigin
    @PutMapping("/put/done")
    public String postOngoingInfo(@RequestParam(value = "alertNo", defaultValue = "0") String alertNo,
    @RequestParam(value = "address", defaultValue = "0") String address) {
        //TODO: process POST request
        logger.info("put done");
        
        return putAlertInfoService.done(alertNo,address);
    }

    @CrossOrigin
    @PutMapping("/put/doneAll")
    public String postOngoingInfo( @RequestParam(value = "address", defaultValue = "0") String address) {
        //TODO: process POST request
        logger.info("put doneAll");
        
        return putAlertInfoService.doneAll(address);
    }

    @CrossOrigin
    @PostMapping("/post")
    public String put( @RequestParam(value = "alertNo", defaultValue = "0") String alertNo) {
        //TODO: process POST request
        logger.info("post");
        
        return postAlertingInfoService.post(alertNo);
    }
    
    
}
