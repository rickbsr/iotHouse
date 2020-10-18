package com.iot.ihouse.view.activity;

public enum NodeType {
    TEMP("temp"),
    HUM("hum"),
    NOISE("noise");

    private final String value;

    NodeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
