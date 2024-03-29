package com.example.smac.domain;

import java.util.List;

public class AllAlertInfoEntity{
    private String updateTime;
    private List<AlertInfoEntity> alertingInfoList;
    private List<AlertInfoEntity> ongoingInfoList;
    private SoundInfoEntity soundInfo;
    
    public AllAlertInfoEntity(String updateTime, List<AlertInfoEntity> alertingInfoList,
            List<AlertInfoEntity> ongoingInfoList, SoundInfoEntity soundInfo) {
        this.updateTime = updateTime;
        this.alertingInfoList = alertingInfoList;
        this.ongoingInfoList = ongoingInfoList;
        this.soundInfo = soundInfo;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<AlertInfoEntity> getAlertingInfoList() {
        return alertingInfoList;
    }

    public void setAlertingInfoList(List<AlertInfoEntity> alertingInfoList) {
        this.alertingInfoList = alertingInfoList;
    }

    public List<AlertInfoEntity> getOngoingInfoList() {
        return ongoingInfoList;
    }

    public void setOngoingInfoList(List<AlertInfoEntity> ongoingInfoList) {
        this.ongoingInfoList = ongoingInfoList;
    }

    public SoundInfoEntity getSoundInfo() {
        return soundInfo;
    }

    public void setSoundInfo(SoundInfoEntity soundInfo) {
        this.soundInfo = soundInfo;
    }
    
    

    
}
