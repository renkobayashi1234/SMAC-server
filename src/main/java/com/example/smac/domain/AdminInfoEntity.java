package com.example.smac.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="M_KANSI")
public class AdminInfoEntity {
    @Id
    @Column(name="ALERTBANGO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String alertNo;

    @Column(name="SABAMEISYO", nullable =false)
    private String server;

    @Column(name = "NOTESRENKEI", nullable = true)
    private int notesFlag;

    @Column(name= "ONSEIMEISYO",nullable = false)
    private String soundUrl;

    @Column(name = "SAKUSEINITIJI", nullable = false)
    private LocalDateTime makeTime;

    @Column(name = "KOUSINNITIJI", nullable = false)
    private LocalDateTime updateTime;

    @Column(name = "SAKUJYOFURAGU",nullable = false)
    private int availableFlag;

    public String getAlertNo() {
        return alertNo;
    }

    public void setAlertNo(String alertNo) {
        this.alertNo = alertNo;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getNotesFlag() {
        return notesFlag;
    }

    public void setNotesFlag(int notesFlag) {
        this.notesFlag = notesFlag;
    }

    public String getSoundUrl() {
        return soundUrl;
    }

    public void setSoundUrl(String soundUrl) {
        this.soundUrl = soundUrl;
    }

    public LocalDateTime getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(LocalDateTime makeTime) {
        this.makeTime = makeTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public int getAvailableFlag() {
        return availableFlag;
    }

    public void setAvailableFlag(int availableFlag) {
        this.availableFlag = availableFlag;
    }
    
    
    
}
