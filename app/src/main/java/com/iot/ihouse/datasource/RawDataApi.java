package com.iot.ihouse.datasource;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RawDataApi {
    @GET("device/{device_id}/sensor/{sensor_id}/rawdata")
    Call<List<NodeRawDataItem>> getNodeRawDataList(@Path("device_id") String deviceId,
                                                   @Path("sensor_id" ) String sensorId,
                                                   @Query("start") String startTime,
                                                   @Query("end") String endTime);
}