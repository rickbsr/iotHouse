package com.iot.ihouse.view.activity.nodelist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iot.ihouse.databinding.ItemNodeBinding;
import com.iot.ihouse.datasource.SensorItem;

public class NodeViewHolder extends RecyclerView.ViewHolder {
    ItemNodeBinding binding;
    NodeClickCallback callback;
    public NodeViewHolder(@NonNull ItemNodeBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(SensorItem sensorItem){
        binding.nodeName.setText(sensorItem.getName());
        binding.nodeLocation.setText(sensorItem.getDesc());
        binding.btnMore.setOnClickListener(view ->{
            if(callback!=null){
                callback.onNodeClick(sensorItem);
            }
        });
    }

    public void setCallback(NodeClickCallback callback) {
        this.callback = callback;
    }
}
