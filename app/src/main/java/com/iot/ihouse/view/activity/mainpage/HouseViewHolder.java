package com.iot.ihouse.view.activity.mainpage;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iot.ihouse.databinding.ItemHouseBinding;

public class HouseViewHolder extends RecyclerView.ViewHolder {
    ItemHouseBinding binding;
    HouseClickCallback houseClickCallback;

    public HouseViewHolder(@NonNull ItemHouseBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(HouseBO houseBO) {
        binding.houseName.setText(houseBO.name);
        binding.houseStatus.setText(houseBO.status);
        binding.btnMore.setOnClickListener(view -> {
            if (houseClickCallback != null) {
                houseClickCallback.onHouseItemClick(houseBO);
            }
        });
    }

    public void setHouseClickCallback(HouseClickCallback houseClickCallback) {
        this.houseClickCallback = houseClickCallback;
    }
}
