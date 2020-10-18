package com.iot.ihouse.view.activity.houseoverview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.iot.ihouse.R;
import com.iot.ihouse.databinding.ActivityHouseOverviewBinding;
import com.iot.ihouse.view.activity.NodeType;
import com.iot.ihouse.view.activity.nodelist.NodeListActivity;

import static com.iot.ihouse.view.activity.mainpage.MainActivity.INTENT_KEY_HOUSE_ID;

public class HouseOverviewActivity extends AppCompatActivity {
    public final static String INTENT_NODE_TYPE = "node_type";

    ActivityHouseOverviewBinding binding;
    HouseOverviewViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_house_overview);
        viewModel = new ViewModelProvider(this).get(HouseOverviewViewModel.class);
        viewModel.setHouseId(getIntent().getStringExtra(INTENT_KEY_HOUSE_ID));
        viewModel.fetchHouseData();
        initObserver();
        initListener();
    }

    private void initListener() {

        binding.ibtnHum.setOnClickListener(view ->{
            if(viewModel.getHouseId()!=null){
                Intent intent = new Intent(HouseOverviewActivity.this, NodeListActivity.class);
                intent.putExtra(INTENT_KEY_HOUSE_ID,viewModel.getHouseId());
                intent.putExtra(INTENT_NODE_TYPE, NodeType.HUM.getValue());
                startActivity(intent);
            }
        });

        binding.ibtnNoise.setOnClickListener(view ->{
            if(viewModel.getHouseId()!=null){
                Intent intent = new Intent(HouseOverviewActivity.this, NodeListActivity.class);
                intent.putExtra(INTENT_KEY_HOUSE_ID,viewModel.getHouseId());
                intent.putExtra(INTENT_NODE_TYPE, NodeType.NOISE.getValue());
                startActivity(intent);

            }
        });

        binding.ibtnTemp.setOnClickListener(view ->{
            if(viewModel.getHouseId()!=null){
                Intent intent = new Intent(HouseOverviewActivity.this, NodeListActivity.class);
                intent.putExtra(INTENT_KEY_HOUSE_ID,viewModel.getHouseId());
                intent.putExtra(INTENT_NODE_TYPE, NodeType.TEMP.getValue());
                startActivity(intent);

            }
        });

    }

    private void initObserver() {
        viewModel.getHouseOverviewBO().observe(this, houseOverviewBO -> {
            if(houseOverviewBO!=null){
                binding.tvHouseName.setText(houseOverviewBO.getHouseName());
                binding.tvHouseAddress.setText(houseOverviewBO.getHouseAddress());
                binding.tvHumLevel.setText(houseOverviewBO.getHumLevel());
                binding.tvNoiseLevel.setText(houseOverviewBO.getNoiseLevel());
                binding.tvTempLevel.setText(houseOverviewBO.getTempLevel());
            }
        });
    }
}