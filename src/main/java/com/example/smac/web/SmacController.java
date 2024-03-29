package com.example.smac.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.smac.domain.AllAlertInfoEntity;
import com.example.smac.service.GetAlertInfoService;
import com.example.smac.service.PostAlertInfoService;
import com.example.smac.service.PutAlertingInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    PostAlertInfoService postAlertInfoService;

    @Autowired
    PutAlertingInfoService putAlertingInfoService;

    @CrossOrigin
    @GetMapping("/get")
    public AllAlertInfoEntity get(){
        return getAlertInfoService.getAlertInfo();
    }

    @CrossOrigin
    @PostMapping("/post/callOff")
    public String postAlertingInfo(@RequestParam(value = "alertNo", defaultValue = "0") String alertNo,
    @RequestParam(value = "address", defaultValue = "0") String address) {
        //TODO: process POST request
        logger.info("post callOff!");
        
        return postAlertInfoService.callOff(alertNo,address);
    }

    @CrossOrigin
    @PostMapping("/post/done")
    public String postOngoingInfo(@RequestParam(value = "alertNo", defaultValue = "0") String alertNo,
    @RequestParam(value = "address", defaultValue = "0") String address) {
        //TODO: process POST request
        logger.info("post done");
        
        return postAlertInfoService.done(alertNo,address);
    }

    @CrossOrigin
    @PostMapping("/post/doneAll")
    public String postOngoingInfo( @RequestParam(value = "address", defaultValue = "0") String address) {
        //TODO: process POST request
        logger.info("post doneAll");
        
        return postAlertInfoService.doneAll(address);
    }

    @CrossOrigin
    @PostMapping("/put")
    public String put( @RequestParam(value = "alertNo", defaultValue = "0") String alertNo) {
        //TODO: process POST request
        logger.info("put");
        
        return putAlertingInfoService.put(alertNo);
    }
    

}
