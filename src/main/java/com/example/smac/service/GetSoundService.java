package com.example.smac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.smac.domain.AdminInfoEntity;
import com.example.smac.domain.AdminInfoRepository;
import com.example.smac.domain.AlertInfoEntity;
import com.example.smac.domain.SoundInfoEntity;

@Service
public class GetSoundService {
    @Autowired
    AdminInfoRepository adminInfoRepository;

    @Value("${audio.target}")
    private String target;

    public SoundInfoEntity getSoundInfo(List<AlertInfoEntity> alertingInfoList){
        int siz = alertingInfoList.size();
        boolean soundFlag = (siz==0)? false:true;

        if(!soundFlag){
            return new SoundInfoEntity(false, "");
        }
        
        //先頭のalert No (発生日時が最新のもの)を返す
        int soundAlertNo = (target.equals("latest"))? alertingInfoList.get(0).getAlertNo() : alertingInfoList.get(siz-1).getAlertNo();
        
        String soundUrl = getSoundUrl(soundAlertNo);

        return new SoundInfoEntity(true, soundUrl);
        
    }

    private String getSoundUrl(int alertNo){
        //implementation

        String soundUrl="";

        for(AdminInfoEntity entity:adminInfoRepository.findByAlertNo(String.valueOf(alertNo))){
            soundUrl=entity.getSoundUrl();
        }
        return soundUrl;
    }
}
