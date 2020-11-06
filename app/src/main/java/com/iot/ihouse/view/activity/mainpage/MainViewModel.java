package com.iot.ihouse.view.activity.mainpage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iot.ihouse.datasource.DeviceItem;
import com.iot.ihouse.datasource.IotRetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<List<DeviceItem>> deviceItemList;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    LiveData<List<DeviceItem>> getDeviceItemList() {
        if (deviceItemList == null) {
            deviceItemList = new MutableLiveData<>();
        }
        fetchHouseList();
        return deviceItemList;
    }

    private void fetchHouseList() {
        IotRetrofitClient.getInstance().getNodeDataApi().getDeviceList().enqueue(new Callback<List<DeviceItem>>() {
            @Override
            public void onResponse(Call<List<DeviceItem>> call, Response<List<DeviceItem>> response) {
                if(response.body()!=null){
                    deviceItemList.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<DeviceItem>> call, Throwable t) {

            }
        });
    }
}
