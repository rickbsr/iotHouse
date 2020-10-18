package com.iot.ihouse.view.activity.houseoverview;

public class HouseOverviewBO {
    private String houseId;
    private String houseName;
    private String houseAddress;
    private String noiseLevel;
    private String tempLevel;
    private String humLevel;

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public String getTempLevel() {
        return tempLevel;
    }

    public void setTempLevel(String tempLevel) {
        this.tempLevel = tempLevel;
    }

    public String getHumLevel() {
        return humLevel;
    }

    public void setHumLevel(String humLevel) {
        this.humLevel = humLevel;
    }
}
