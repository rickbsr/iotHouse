package com.iot.ihouse.view.activity.houseoverview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class HouseOverviewViewModel extends AndroidViewModel {
    String houseId;
    MutableLiveData<HouseOverviewBO> houseOverviewBO;
    public HouseOverviewViewModel(@NonNull Application application) {
        super(application);
        houseOverviewBO = new MutableLiveData<>();

    }

    public LiveData<HouseOverviewBO> getHouseOverviewBO() {
        return houseOverviewBO;
    }

    public void fetchHouseData(){
        HouseOverviewBO fakeHouseOverviewBO = new HouseOverviewBO();
        fakeHouseOverviewBO.setHouseId(houseId);
        fakeHouseOverviewBO.setHouseName("名稱：中和中正路凱悅社區小套2");
        fakeHouseOverviewBO.setHouseAddress("新北市中和區中正路755號10樓之2");
        fakeHouseOverviewBO.setNoiseLevel("噪音程度：中等");
        fakeHouseOverviewBO.setTempLevel("溫度狀態：舒適");
        fakeHouseOverviewBO.setHumLevel("濕度狀態：潮濕");
        houseOverviewBO.postValue(fakeHouseOverviewBO);
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }
}
