
package com.iot.ihouse.datasource;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class DeviceItem {

    @Expose
    private List<Object> attributes;
    @Expose
    private String desc;
    @Expose
    private String id;
    @Expose
    private Double lat;
    @Expose
    private Double lon;
    @Expose
    private String name;
    @Expose
    private String type;
    @Expose
    private String uri;

    public List<Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "DeviceItem{" +
                "attributes=" + attributes +
                ", desc='" + desc + '\'' +
                ", id='" + id + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
