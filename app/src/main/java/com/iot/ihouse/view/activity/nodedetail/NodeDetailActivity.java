package com.iot.ihouse.view.activity.nodedetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.iot.ihouse.R;
import com.iot.ihouse.databinding.ActivityNodeDetailBindingImpl;
import com.iot.ihouse.datasource.NodeRawDataItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.iot.ihouse.view.activity.mainpage.MainActivity.INTENT_KEY_HOUSE_ID;
import static com.iot.ihouse.view.activity.nodelist.NodeListActivity.INTENT_KEY_NODE_ID;
import static com.iot.ihouse.view.activity.nodelist.NodeListActivity.INTENT_KEY_SENSOR_TYPE;

public class NodeDetailActivity extends AppCompatActivity {
    ActivityNodeDetailBindingImpl binding;
    NodeDetailViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_node_detail);
        viewModel = new ViewModelProvider(this).get(NodeDetailViewModel.class);
        viewModel.setHouseId(getIntent().getStringExtra(INTENT_KEY_HOUSE_ID));
        viewModel.setSensorId(getIntent().getStringExtra(INTENT_KEY_NODE_ID));
        viewModel.setSensorType(getIntent().getStringExtra(INTENT_KEY_SENSOR_TYPE));
        viewModel.setFetchTimeType(FetchTimeType.TEN_MIN);
        viewModel.fetchData();
        initObserver();

    }

    private void initObserver() {
        viewModel.getRawDataList().observe(this, new Observer<List<NodeRawDataItem>>() {
            @Override
            public void onChanged(List<NodeRawDataItem> nodeRawDataItems) {
                if(nodeRawDataItems!=null){
                    if(nodeRawDataItems.size()<2){
                        binding.lineChart.setVisibility(View.INVISIBLE);
                        binding.tvNoDataHint.setVisibility(View.VISIBLE);
                    }else{
                        initX(viewModel.getFetchTimeType(),nodeRawDataItems);
                        initChartData(nodeRawDataItems);
                        binding.lineChart.setVisibility(View.VISIBLE);
                        binding.tvNoDataHint.setVisibility(View.INVISIBLE);
                    }

                }
            }
        });
    }

    private void initChartData(List<NodeRawDataItem> nodeRawDataItems) {
        List<Entry> values = new ArrayList<>();
        for(int i = 0;i<nodeRawDataItems.size();i++){
            NodeRawDataItem item = nodeRawDataItems.get(i);
//            Log.e("yuli", "initChartData: "+item.getValue().get(0));
            values.add(new Entry(i,i));
        }
        final LineDataSet dataSet = new LineDataSet(values,"聲音");
        dataSet.setMode(LineDataSet.Mode.LINEAR);//類型為折線
        dataSet.setColor(getResources().getColor(R.color.colorAccent));//線的顏色
        dataSet.setLineWidth(1.5f);//線寬

        LineData data = new LineData(dataSet);
        binding.lineChart.setData(data);
        binding.lineChart.invalidate();//繪製圖表
    }

    private void initX(FetchTimeType fetchTimeType,List<NodeRawDataItem> nodeRawDataItemList) {
        XAxis xAxis = binding.lineChart.getXAxis();

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//X軸標籤顯示位置(預設顯示在上方，分為上方內/外側、下方內/外側及上下同時顯示)
        xAxis.setSpaceMin(0.5f);//折線起點距離左側Y軸距離
        xAxis.setSpaceMax(0.5f);//折線終點距離右側Y軸距離

//        switch (fetchTimeType){
//            case TEN_MIN:
//                xAxis.setLabelCount(11);//X軸標籤個數
//                //設定所需特定標籤資料
//                String[] xValue = new String[]{"", "10分", "9分", "8分", "7分", "6分", "5分", "4分", "3分", "2分", "1分"};
//                List<String> xList = new ArrayList<>(Arrays.asList(xValue));
//                xAxis.setValueFormatter(new IndexAxisValueFormatter(xList));
//
//
//        }
        List<String> xList = new ArrayList<>();
        for(int i = 0;i<nodeRawDataItemList.size();i++){
            NodeRawDataItem nodeRawDataItem = nodeRawDataItemList.get(i);
            xList.add(nodeRawDataItem.getTime());
        }
        xAxis.setLabelCount(nodeRawDataItemList.size());
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xList));

    }
}