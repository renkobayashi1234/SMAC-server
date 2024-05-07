package com.example.smac.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/settingProperties")
public class SettingController {

    @Value("${connection.interval}")
    private int connectionInterval;

    @CrossOrigin
    @GetMapping("/connectionInterval")
    public int getConnectionInterval(){
        return connectionInterval;
    }

    @Value("${audio.time}")
    private int audioPlayTime;

    @CrossOrigin
    @GetMapping("/audioPlayTime")
    public int getAudioPlayTime() {
        return audioPlayTime;
    }
    
}
