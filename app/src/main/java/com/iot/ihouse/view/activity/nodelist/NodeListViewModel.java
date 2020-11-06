package com.iot.ihouse.view.activity.nodelist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iot.ihouse.datasource.IotRetrofitClient;
import com.iot.ihouse.datasource.SensorItem;
import com.iot.ihouse.view.activity.NodeStatus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NodeListViewModel extends AndroidViewModel {
    private String houseId;
    private MutableLiveData<List<SensorItem>> sensorItemList;
    public NodeListViewModel(@NonNull Application application) {
        super(application);
        sensorItemList = new MutableLiveData<>();
    }

    public LiveData<List<SensorItem>> getNodeList() {
        return sensorItemList;
    }

    public void fetchData(){
        if(sensorItemList==null){
            sensorItemList = new MutableLiveData<>();
        }
        IotRetrofitClient.getInstance().getNodeDataApi().getSensorList(houseId).enqueue(new Callback<List<SensorItem>>() {
            @Override
            public void onResponse(Call<List<SensorItem>> call, Response<List<SensorItem>> response) {
                if(response.body()!=null){
                    List<SensorItem> responseList = response.body();
                    sensorItemList.postValue(responseList);
                }
            }

            @Override
            public void onFailure(Call<List<SensorItem>> call, Throwable t) {

            }
        });
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

}
