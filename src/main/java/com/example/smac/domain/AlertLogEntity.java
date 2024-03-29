package com.example.smac.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="M_ALERT_LOG")
public class AlertLogEntity {
    @Id
    @Column(name="SQUNO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ALERTBANGO", nullable = false)
    private String alertNo;

    @Column(name="HASEINITIJI", nullable = false)
    private LocalDateTime fireDate;

    @Column(name="TUTINITIJI", nullable = true)
    private LocalDateTime notifyDate;

    @Column(name="KAYIJYONITIJI", nullable = true)
    private LocalDateTime callOffDate;

    @Column(name="RISETONITIJI", nullable = true)
    private LocalDateTime doneDate;

    @Column(name="KAYIJYOTANMATU", nullable = true)
    private String callOffAddress;

    @Column(name="RISETOTANMATU", nullable = true)
    private String doneAddress;

    @Column(name="KEYIHOUSUTETASU", nullable = false)
    private int status;

    @Column(name="SAYISINFURAGU", nullable = false)
    private int newest;

    public int getId() {
        return id;
    }

    public String getAlertNo() {
        return alertNo;
    }

    public LocalDateTime getFireDate() {
        return fireDate;
    }

    public LocalDateTime getNotifyDate() {
        return notifyDate;
    }

    public LocalDateTime getCallOffDate() {
        return callOffDate;
    }

    public LocalDateTime getDoneDate() {
        return doneDate;
    }

    public String getCallOffAddress() {
        return callOffAddress;
    }

    public String getDoneAddress() {
        return doneAddress;
    }

    public int getStatus() {
        return status;
    }

    public int getNewest() {
        return newest;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlertNo(String alertNo) {
        this.alertNo = alertNo;
    }

    public void setFireDate(LocalDateTime fireDate) {
        this.fireDate = fireDate;
    }

    public void setNotifyDate(LocalDateTime notifyDate) {
        this.notifyDate = notifyDate;
    }

    public void setCallOffDate(LocalDateTime callOffDate) {
        this.callOffDate = callOffDate;
    }

    public void setDoneDate(LocalDateTime doneDate) {
        this.doneDate = doneDate;
    }

    public void setCallOffAddress(String callOffAddress) {
        this.callOffAddress = callOffAddress;
    }

    public void setDoneAddress(String doneAddress) {
        this.doneAddress = doneAddress;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setNewest(int newest) {
        this.newest = newest;
    }

    @Override
    public String toString() {
        return "AlertInfoEntity [id=" + id + ", alertNo=" + alertNo + ", fireDate=" + fireDate + ", notifyDate="
                + notifyDate + ", callOffDate=" + callOffDate + ", doneDate=" + doneDate + ", callOffAddress="
                + callOffAddress + ", doneAddress=" + doneAddress + ", status=" + status + ", newest=" + newest + "]";
    }

    
}
