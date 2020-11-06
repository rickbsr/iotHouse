package com.iot.ihouse.view.activity.mainpage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.iot.ihouse.R;
import com.iot.ihouse.databinding.ActivityMainBinding;
import com.iot.ihouse.view.activity.houseoverview.HouseOverviewActivity;

public class MainActivity extends AppCompatActivity {
    public final static String INTENT_KEY_HOUSE_ID = "house_id";
    ActivityMainBinding binding;
    MainViewModel viewModel;
    HouseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel  = new ViewModelProvider(this).get(MainViewModel.class);
        adapter = new HouseListAdapter();
        binding.rvHouseList.setAdapter(adapter);
        binding.rvHouseList.setLayoutManager(new LinearLayoutManager(this));
        initObserver();
        initListener();
    }

    private void initListener() {
        adapter.setHouseClickCallback(deviceItem -> {
            Intent intent = new Intent(MainActivity.this, HouseOverviewActivity.class);
            intent.putExtra(INTENT_KEY_HOUSE_ID,deviceItem.getId());
            startActivity(intent);
        });
    }

    private void initObserver() {
        viewModel.getDeviceItemList().observe(this, deviceItemList -> {
            if(deviceItemList!=null){
                adapter.setDeviceItemList(deviceItemList);
                adapter.notifyDataSetChanged();
            }
        });
    }
}