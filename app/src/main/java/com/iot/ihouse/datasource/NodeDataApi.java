package com.iot.ihouse.datasource;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NodeDataApi {
    @GET("device")
    Call<List<DeviceItem>> getDeviceList();

    @GET("device/{device_id}")
    Call<List<DeviceItem>> getDeviceList(@Path("device_id") String deviceId);

    @GET("device/{device_id}/sensor")
    Call<List<SensorItem>> getSensorList(@Path("device_id") String deviceId);

    @GET("device/{device_id}/sensor/{sensor_id}")
    Call<List<SensorItem>> getSensorList(@Path("device_id") String deviceId,
                                         @Path("sensor_id") String sensorId);

    @GET("metadata")
    Call<List<MetaDataItem>> getMetaDataList();
}