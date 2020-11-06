package com.iot.ihouse.view.activity.mainpage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iot.ihouse.datasource.DeviceItem;
import com.iot.ihouse.datasource.IotRetrofitClient;
import com.iot.ihouse.repo.IotRemoteRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<List<HouseBO>> houseBOList;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    LiveData<List<HouseBO>> getHouseBOList() {
        if (houseBOList == null) {
            houseBOList = new MutableLiveData<>();
        }
        fetchHouseList();
        return houseBOList;
    }

    private void fetchHouseList() {
        IotRetrofitClient.getInstance().getNodeDataApi().getDeviceList().enqueue(new Callback<List<DeviceItem>>() {
            @Override
            public void onResponse(Call<List<DeviceItem>> call, Response<List<DeviceItem>> response) {
                if(response.body()!=null){
                    processToHouseBO(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<DeviceItem>> call, Throwable t) {

            }
        });
    }

    private void processToHouseBO(List<DeviceItem> deviceItemList) {
        List<HouseBO> houseDataList = new ArrayList<>();
        for(int i = 0;i<deviceItemList.size();i++){
            DeviceItem item = deviceItemList.get(i);
            HouseBO houseBO = new HouseBO(String.valueOf(i+1),item.getDesc(),"安全");
            houseDataList.add(houseBO);
        }
        houseBOList.postValue(houseDataList);
    }
}
