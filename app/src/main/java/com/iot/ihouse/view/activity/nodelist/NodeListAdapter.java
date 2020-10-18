package com.iot.ihouse.view.activity.nodelist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.iot.ihouse.R;
import com.iot.ihouse.databinding.ItemNodeBinding;

import java.util.List;

public class NodeListAdapter extends RecyclerView.Adapter<NodeViewHolder> {
    List<NodeBO> nodeBOList;
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
        NodeBO nodeBO =nodeBOList.get(position);
        if(nodeBO!=null){
            holder.bind(nodeBO);
        }
        if(nodeClickCallback!=null){
            holder.setCallback(nodeClickCallback);
        }
    }

    @Override
    public int getItemCount() {
        return nodeBOList==null?0:nodeBOList.size();
    }

    public void setNodeBOList(List<NodeBO> nodeBOList) {
        this.nodeBOList = nodeBOList;
    }

    public void setNodeClickCallback(NodeClickCallback nodeClickCallback) {
        this.nodeClickCallback = nodeClickCallback;
    }
}
