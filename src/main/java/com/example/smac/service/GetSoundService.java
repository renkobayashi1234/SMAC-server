package com.example.smac.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.smac.domain.AlertInfoEntity;
import com.example.smac.domain.SoundInfoEntity;

@Service
public class GetSoundService {
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

        return "/sounds/sound1.mp3";
    }
}
