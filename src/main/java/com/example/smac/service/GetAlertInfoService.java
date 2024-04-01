package com.example.smac.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smac.domain.AlertInfoEntity;
import com.example.smac.domain.AlertLogEntity;
import com.example.smac.domain.AlertLogRepository;
import com.example.smac.domain.AllAlertInfoEntity;
import com.example.smac.domain.SoundInfoEntity;

@Service
public class GetAlertInfoService {

    @Autowired
    AlertLogRepository alertLogRepository;

    @Autowired
    GetSoundService getSoundService;

    public AllAlertInfoEntity getAlertInfo(){

        //未通知のものを通知済みにする
        notifyLog();

        //データ取得
        List<AlertInfoEntity> alertingInfoList = getAlertingInfoList();
        List<AlertInfoEntity> ongoingInfoList = getOngoingInfoList();

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String updateTime = LocalDateTime.now().format(formatter);

        SoundInfoEntity soundInfo = getSoundService.getSoundInfo(alertingInfoList);

        return new AllAlertInfoEntity(
            updateTime, 
            alertingInfoList, 
            ongoingInfoList, 
            soundInfo);
    }

    private void notifyLog(){
        List<AlertLogEntity> notifiedLogList = new ArrayList<>();
        //未通知(status:0)のログを解除待ち(status:1)にする
        for(AlertLogEntity log : alertLogRepository.findByStatus(0)){
            log.setStatus(1);
            log.setNotifyDate(LocalDateTime.now());
            notifiedLogList.add(log);
        }
        alertLogRepository.saveAll(notifiedLogList);
    }

    private List<AlertInfoEntity> getAlertingInfoList(){
        List<AlertInfoEntity> alertingInfoList = new ArrayList<>();
        //解除待ち(status:1)のリストを発生日時(fireData)の降順で返す。
        List<AlertLogEntity> logList=alertLogRepository.findByStatus(1)
                                                       .stream()
                                                       .sorted(Comparator.comparing(AlertLogEntity::getFireDate).reversed())
                                                       .toList();
        for(AlertLogEntity log : logList){
            alertingInfoList.add(AlertInfoEntity.makeFromLog(log));
        }

        return alertingInfoList;
    }

    private List<AlertInfoEntity> getOngoingInfoList(){
        List<AlertInfoEntity> ongoingInfoList = new ArrayList<>();
        //完了待ち(status:2)のリストをは解除日時(calloffDate)の昇順で返す。
        List<AlertLogEntity> logList=alertLogRepository.findByStatus(2)
                                                       .stream()
                                                       .sorted(Comparator.comparing(AlertLogEntity::getCallOffDate))
                                                       .toList();
        for(AlertLogEntity log : logList){
            ongoingInfoList.add(AlertInfoEntity.makeFromLog(log));
        }

        return ongoingInfoList;
    }
}
