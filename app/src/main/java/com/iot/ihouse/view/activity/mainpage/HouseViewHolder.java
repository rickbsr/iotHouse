package com.iot.ihouse.view.activity.mainpage;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iot.ihouse.databinding.ItemHouseBinding;
import com.iot.ihouse.datasource.DeviceItem;

public class HouseViewHolder extends RecyclerView.ViewHolder {
    ItemHouseBinding binding;
    HouseClickCallback houseClickCallback;

    public HouseViewHolder(@NonNull ItemHouseBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(DeviceItem deviceItem) {
        binding.houseName.setText(deviceItem.getName());
        binding.houseStatus.setText("安全");
        binding.btnMore.setOnClickListener(view -> {
            if (houseClickCallback != null) {
                houseClickCallback.onHouseItemClick(deviceItem);
            }
        });
    }

    public void setHouseClickCallback(HouseClickCallback houseClickCallback) {
        this.houseClickCallback = houseClickCallback;
    }
}
