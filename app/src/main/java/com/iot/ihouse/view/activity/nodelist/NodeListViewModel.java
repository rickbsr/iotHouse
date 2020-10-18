package com.iot.ihouse.view.activity.nodelist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iot.ihouse.view.activity.NodeStatus;

import java.util.ArrayList;
import java.util.List;

public class NodeListViewModel extends AndroidViewModel {
    MutableLiveData<List<NodeBO>> nodeBOList;
    public NodeListViewModel(@NonNull Application application) {
        super(application);
        nodeBOList = new MutableLiveData<>();

    }

    public LiveData<List<NodeBO>> getNodeList() {
        return nodeBOList;
    }

    public void fetchData(){
        if(nodeBOList==null){
            nodeBOList = new MutableLiveData<>();
        }

        List<NodeBO> fakeNodeBOList = new ArrayList<>();
        for(int i=0;i<5 ;i++){
            NodeBO nodeBO = new NodeBO();
            nodeBO.setNodeId(String.valueOf(i));
            nodeBO.setNodeLocation("某處"+i);
            nodeBO.setNodeName("node名稱"+i);
            if(i%2==0){
                nodeBO.setNodeStatus(NodeStatus.CONNECT.getValue());
            }else{
                nodeBO.setNodeStatus(NodeStatus.DISCONNECT.getValue());
            }
            fakeNodeBOList.add(nodeBO);
        }
        nodeBOList.postValue(fakeNodeBOList);

    }
}
