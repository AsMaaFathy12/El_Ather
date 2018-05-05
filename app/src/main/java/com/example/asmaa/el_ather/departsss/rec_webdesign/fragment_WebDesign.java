package com.example.asmaa.el_ather.departsss.rec_webdesign;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmaa.el_ather.R;
import com.example.asmaa.el_ather.departsss.rec_android.Adapter;
import com.example.asmaa.el_ather.departsss.rec_android.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AsMaa on 2/17/2018.
 */

public class fragment_WebDesign extends Fragment {
RecyclerView mRecyclerView;
List<com.example.asmaa.el_ather.departsss.rec_android.Model> data;
Adapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_webdesign,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recy_android);
       LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        Log.d("debugMode", "The application stopped after this");
        mRecyclerView.setLayoutManager(mLayoutManager);
     data=new ArrayList<>();
     com.example.asmaa.el_ather.departsss.rec_android.Model l1=new Model();
     l1.setImg(R.drawable.alatheers);
     l1.setTitle("Alatheeeeeer Project");
     data.add(l1);
        mAdapter = new Adapter(data);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
