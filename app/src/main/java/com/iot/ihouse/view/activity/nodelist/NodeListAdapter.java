package com.iot.ihouse.view.activity.nodelist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.iot.ihouse.R;
import com.iot.ihouse.databinding.ItemNodeBinding;
import com.iot.ihouse.datasource.SensorItem;

import java.util.List;

public class NodeListAdapter extends RecyclerView.Adapter<NodeViewHolder> {
    List<SensorItem> sensorItemList;
    NodeClickCallback nodeClickCallback;
    @NonNull
    @Override
    public NodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNodeBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_node, parent, false);
        return new NodeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NodeViewHolder holder, int position) {
        SensorItem sensorItem =sensorItemList.get(position);
        if(sensorItem!=null){
            holder.bind(sensorItem);
        }
        if(nodeClickCallback!=null){
            holder.setCallback(nodeClickCallback);
        }
    }

    @Override
    public int getItemCount() {
        return sensorItemList==null?0:sensorItemList.size();
    }

    public void setNodeBOList(List<SensorItem> sensorItemList) {
        this.sensorItemList = sensorItemList;
    }

    public void setNodeClickCallback(NodeClickCallback nodeClickCallback) {
        this.nodeClickCallback = nodeClickCallback;
    }
}
