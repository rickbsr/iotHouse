package com.iot.ihouse.view.activity.nodelist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iot.ihouse.databinding.ItemNodeBinding;

public class NodeViewHolder extends RecyclerView.ViewHolder {
    ItemNodeBinding binding;
    NodeClickCallback callback;
    public NodeViewHolder(@NonNull ItemNodeBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(NodeBO nodeBO){
        binding.nodeName.setText(nodeBO.getNodeName());
        binding.nodeLocation.setText(nodeBO.getNodeLocation());
        binding.btnMore.setOnClickListener(view ->{
            if(callback!=null){
                callback.onNodeClick(nodeBO);
            }
        });
    }

    public void setCallback(NodeClickCallback callback) {
        this.callback = callback;
    }
}
