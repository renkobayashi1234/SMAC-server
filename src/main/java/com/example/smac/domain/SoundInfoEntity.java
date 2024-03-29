package com.example.smac.domain;

public class SoundInfoEntity {
    private boolean soundFlag;
    private String soundUrl;
    
    public SoundInfoEntity(boolean soundFlag, String soundUrl) {
        this.soundFlag = soundFlag;
        this.soundUrl = soundUrl;
    }

    public boolean isSoundFlag() {
        return soundFlag;
    }

    public void setSoundFlag(boolean soundFlag) {
        this.soundFlag = soundFlag;
    }

    public String getSoundUrl() {
        return soundUrl;
    }

    public void setSoundUrl(String soundUrl) {
        this.soundUrl = soundUrl;
    }

    
}
