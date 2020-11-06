package com.iot.ihouse.view.activity.nodelist;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.iot.ihouse.R;
import com.iot.ihouse.databinding.ActivityNodeListBinding;
import com.iot.ihouse.view.activity.nodedetail.NodeDetailActivity;

import java.util.List;

import static com.iot.ihouse.view.activity.mainpage.MainActivity.INTENT_KEY_HOUSE_ID;

public class NodeListActivity extends AppCompatActivity {
    public final static String INTENT_KEY_NODE_ID = "node_id";
    public static final String INTENT_KEY_SENSOR_TYPE = "sensor_type";

    ActivityNodeListBinding binding;
    NodeListAdapter adapter;
    NodeListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_node_list);
        viewModel = new ViewModelProvider(this).get(NodeListViewModel.class);
        viewModel.setHouseId(getIntent().getStringExtra(INTENT_KEY_HOUSE_ID));
        viewModel.fetchData();
        adapter = new NodeListAdapter();
        adapter.setNodeClickCallback(sensorItem -> {
            Intent intent = new Intent(NodeListActivity.this, NodeDetailActivity.class);
            intent.putExtra(INTENT_KEY_HOUSE_ID,viewModel.getHouseId());
            intent.putExtra(INTENT_KEY_NODE_ID, sensorItem.getId());
            intent.putExtra(INTENT_KEY_SENSOR_TYPE, sensorItem.getType());
            startActivity(intent);
        });
        binding.rvNodelist.setAdapter(adapter);
        binding.rvNodelist.setLayoutManager(new LinearLayoutManager(this));

        initObserver();
    }

    private void initObserver() {
        viewModel.getNodeList().observe(this, nodeBOS -> {
            if(nodeBOS!=null){
                adapter.setNodeBOList(nodeBOS);
                adapter.notifyDataSetChanged();
            }
        });
    }
}