
package com.iot.ihouse.datasource;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class NodeRawDataItem {

    @Expose
    private String deviceId;
    @Expose
    private String id;
    @Expose
    private Double lat;
    @Expose
    private Double lon;
    @Expose
    private String time;
    @Expose
    private List<String> value;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

}
