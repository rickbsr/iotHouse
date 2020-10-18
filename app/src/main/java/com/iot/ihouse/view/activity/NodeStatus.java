package com.iot.ihouse.view.activity;

public enum NodeStatus {
    CONNECT("connect"),
    DISCONNECT("disconnect");

    private final String value;

    NodeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
