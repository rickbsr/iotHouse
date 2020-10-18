package com.iot.ihouse.view.activity.nodedetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.iot.ihouse.R;
import com.iot.ihouse.databinding.ActivityNodeDetailBindingImpl;

import java.util.ArrayList;
import java.util.List;

public class NodeDetailActivity extends AppCompatActivity {
    ActivityNodeDetailBindingImpl binding;
    NodeDetailViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_node_detail);
        viewModel = new ViewModelProvider(this).get(NodeDetailViewModel.class);
        initX();
        initChartData();
    }

    private void initChartData() {
        ArrayList<Entry> values = new ArrayList<>();
        values.add(new Entry(1, 2));
        values.add(new Entry(2, 4));
        values.add(new Entry(3, 4));
        values.add(new Entry(4, 6));
        values.add(new Entry(5, 7));
        values.add(new Entry(6, 6));



        final LineDataSet dataSet = new LineDataSet(values,"溫度");
        dataSet.setMode(LineDataSet.Mode.LINEAR);//類型為折線
        dataSet.setColor(getResources().getColor(R.color.colorAccent));//線的顏色
        dataSet.setLineWidth(1.5f);//線寬

        ArrayList<Entry> values2 = new ArrayList<>();
        values2.add(new Entry(1, 5));
        values2.add(new Entry(2, 1));
        values2.add(new Entry(3, 2));
        values2.add(new Entry(4, 4));
        values2.add(new Entry(5, 4));
        values2.add(new Entry(6, 5));



        final LineDataSet dataSet2 = new LineDataSet(values2,"濕度");
        dataSet.setMode(LineDataSet.Mode.LINEAR);//類型為折線
        dataSet.setColor(getResources().getColor(R.color.colorYellow));//線的顏色
        dataSet.setLineWidth(1.5f);//線寬


        LineData data = new LineData(dataSet,dataSet2);
        binding.lineChart.setData(data);
        binding.lineChart.invalidate();//繪製圖表
    }

    private void initX() {
        XAxis xAxis = binding.lineChart.getXAxis();

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//X軸標籤顯示位置(預設顯示在上方，分為上方內/外側、下方內/外側及上下同時顯示)

        xAxis.setLabelCount(6);//X軸標籤個數
        xAxis.setSpaceMin(0.5f);//折線起點距離左側Y軸距離
        xAxis.setSpaceMax(0.5f);//折線終點距離右側Y軸距離

        //設定所需特定標籤資料
        String[] xValue = new String[]{"", "1月", "2月", "3月", "4月", "5月", "6月"};
        List<String> xList = new ArrayList<>();
        for (int i = 0; i < xValue.length; i++) {
            xList.add(xValue[i]);
        }
        /**
         * 格式化軸標籤二種方式：
         * 1、用圖表庫已寫好的類_如下X 軸使用
         * 2、自己實現接口_下一步驟中Y 軸使用
         * */
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xList));
    }
}