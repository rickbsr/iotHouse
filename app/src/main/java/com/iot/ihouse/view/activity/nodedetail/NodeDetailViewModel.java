package com.iot.ihouse.view.activity.nodedetail;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iot.ihouse.datasource.IotRetrofitClient;
import com.iot.ihouse.datasource.NodeRawDataItem;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NodeDetailViewModel extends AndroidViewModel {
    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs

    private String houseId;
    private String sensorId;
    private FetchTimeType fetchTimeType;
    private MutableLiveData<List<NodeRawDataItem>> rawDataList;
    public NodeDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void fetchData(){
        String startTime = "";
        String endTime = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.UK);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        long now = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
        switch (fetchTimeType){
            case TEN_MIN:
                endTime = sdf.format(new Date(now));
                startTime = sdf.format(new Date(now - (10*ONE_MINUTE_IN_MILLIS)));
                if(endTime.contains("+")){
                    int location = endTime.lastIndexOf("+");
                    endTime = endTime.substring(0,location);
                }
                if(startTime.contains("+")){
                    int location = startTime.lastIndexOf("+");
                    startTime = startTime.substring(0,location);
                }

                break;
            case ONE_HOUR:
                endTime = sdf.format(new Date(now));
                startTime = sdf.format(new Date(now - (60 * ONE_MINUTE_IN_MILLIS)));
                break;
            case ONE_DAY:
                endTime = sdf.format(new Date(now));
                startTime = sdf.format(new Date(now - (60 *24* ONE_MINUTE_IN_MILLIS)));
                break;
        }
        //測試用資料
        houseId = "25071267172";
        sensorId = "DHG_vol";
//        startTime = "2020-11-05T13:45:47";
        IotRetrofitClient.getInstance().getRawDataApi().getNodeRawDataList(houseId,sensorId,startTime,endTime).enqueue(new Callback<List<NodeRawDataItem>>() {
            @Override
            public void onResponse(@NotNull Call<List<NodeRawDataItem>> call, @NotNull Response<List<NodeRawDataItem>> response) {
                if(response.body()!=null){
                    if(rawDataList==null){
                        rawDataList = new MutableLiveData<>();
                    }
                    rawDataList.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<NodeRawDataItem>> call, @NotNull Throwable t) {

            }
        });

    }

    public LiveData<List<NodeRawDataItem>> getRawDataList() {
        if(rawDataList==null){
            rawDataList = new MutableLiveData<>();
        }
        return rawDataList;
    }

    public FetchTimeType getFetchTimeType() {
        return fetchTimeType;
    }

    public void setFetchTimeType(FetchTimeType fetchTimeType) {
        this.fetchTimeType = fetchTimeType;
    }

    public void setSensorType(String stringExtra) {
        //todo:finish this
    }
}
