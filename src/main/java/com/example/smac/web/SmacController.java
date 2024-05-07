package com.example.smac.web;

import org.springframework.web.bind.annotation.RestController;
import com.example.smac.domain.AllAlertInfoEntity;
import com.example.smac.service.GetAlertInfoService;
import com.example.smac.service.PutAlertInfoService;

import jakarta.servlet.http.HttpServletRequest;

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

    @Autowired
    private HttpServletRequest request;

    @CrossOrigin
    @GetMapping("/get")
    public AllAlertInfoEntity get(){
        logger.info("Get from "+request.getRemoteAddr());

        return getAlertInfoService.getAlertInfo();
    }

    @CrossOrigin
    @PutMapping("/put/callOff")
    public String putAlertingInfo(@RequestParam(value = "alertNo", defaultValue = "0") String alertNo) {
        logger.info("Put callOff from "+request.getRemoteAddr());
        
        String address=request.getRemoteAddr();

        return putAlertInfoService.callOff(alertNo,address);
    }

    @CrossOrigin
    @PutMapping("/put/done")
    public String putOngoingInfo(@RequestParam(value = "alertNo", defaultValue = "0") String alertNo) {
        
        logger.info("Put done from "+request.getRemoteAddr());

        String address=request.getRemoteAddr();
        
        return putAlertInfoService.done(alertNo,address);
    }

    @CrossOrigin
    @PutMapping("/put/doneAll")
    public String putOngoingInfo() {
        
        logger.info("Put doneAll from "+request.getRemoteAddr());

        String address=request.getRemoteAddr();

        return putAlertInfoService.doneAll(address);
    }

    @CrossOrigin
    @PostMapping("/post")
    public String post( @RequestParam(value = "alertNo", defaultValue = "0") String alertNo) {
        
        logger.info("Post from "+request.getRemoteAddr());
        
        return postAlertingInfoService.post(alertNo);
    }
    
    
}
