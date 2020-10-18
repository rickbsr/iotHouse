package com.iot.ihouse.view.activity.mainpage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<List<HouseBO>> houseBOList;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    LiveData<List<HouseBO>> getHouseBOList() {
        if (houseBOList == null) {
            houseBOList = new MutableLiveData<>();
            fetchHouseList();
        }
        return houseBOList;
    }

    private void fetchHouseList() {
        List<HouseBO> houseDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                HouseBO houseBO = new HouseBO(String.valueOf(i), "第" + i + "間小屋", "安全");
                houseDataList.add(houseBO);
            } else {
                HouseBO houseBO = new HouseBO(String.valueOf(i), "第" + i + "間小屋", "危險");
                houseDataList.add(houseBO);
            }
        }
        houseBOList.postValue(houseDataList);
    }
}
