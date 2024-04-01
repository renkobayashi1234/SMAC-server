package com.example.smac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smac.domain.AdminInfoEntity;
import com.example.smac.domain.AdminInfoRepository;
import com.example.smac.domain.AlertInfoEntity;
import com.example.smac.domain.SoundInfoEntity;

@Service
public class GetSoundService {
    @Autowired
    AdminInfoRepository adminInfoRepository;

    public SoundInfoEntity getSoundInfo(List<AlertInfoEntity> alertingInfoList){
        boolean soundFlag=(alertingInfoList.size()==0)? false:true;

        if(!soundFlag){
            return new SoundInfoEntity(false, "");
        }else{
            int soundAlertNo=alertingInfoList.get(0).getAlertNo();
            String soundUrl = getSoundUrl(soundAlertNo);

            return new SoundInfoEntity(true, soundUrl);
        }
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
