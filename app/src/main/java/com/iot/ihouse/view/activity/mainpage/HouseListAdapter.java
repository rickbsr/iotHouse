package com.iot.ihouse.view.activity.mainpage;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.iot.ihouse.R;
import com.iot.ihouse.databinding.ItemHouseBinding;
import com.iot.ihouse.datasource.DeviceItem;

import java.util.List;

public class HouseListAdapter extends RecyclerView.Adapter<HouseViewHolder>{
    List<DeviceItem> deviceItemList;
    HouseClickCallback houseClickCallback;
    @NonNull
    @Override
    public HouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHouseBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_house, parent, false);
        return new HouseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HouseViewHolder holder, int position) {
        DeviceItem deviceItem = deviceItemList.get(position);
        if(deviceItem!=null){
            holder.bind(deviceItem);
        }
        if(houseClickCallback!=null){
            holder.setHouseClickCallback(houseClickCallback);
        }
    }

    @Override
    public int getItemCount() {
        return deviceItemList ==null?0: deviceItemList.size();
    }

    public void setDeviceItemList(List<DeviceItem> deviceItemList) {
        this.deviceItemList = deviceItemList;
    }

    public void setHouseClickCallback(HouseClickCallback houseClickCallback) {
        this.houseClickCallback = houseClickCallback;
    }
}
