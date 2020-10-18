package com.iot.ihouse.view.activity.mainpage;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.iot.ihouse.R;
import com.iot.ihouse.databinding.ItemHouseBinding;

import java.util.List;

public class HouseListAdapter extends RecyclerView.Adapter<HouseViewHolder>{
    List<HouseBO> houseBOList;
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
        HouseBO houseBO = houseBOList.get(position);
        if(houseBO!=null){
            holder.bind(houseBO);
        }
        if(houseClickCallback!=null){
            holder.setHouseClickCallback(houseClickCallback);
        }
    }

    @Override
    public int getItemCount() {
        return houseBOList==null?0:houseBOList.size();
    }

    public void setHouseBOList(List<HouseBO> houseBOList) {
        this.houseBOList = houseBOList;
    }

    public void setHouseClickCallback(HouseClickCallback houseClickCallback) {
        this.houseClickCallback = houseClickCallback;
    }
}
