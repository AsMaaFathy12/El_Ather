package com.example.asmaa.el_ather.departsss.rec_android;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asmaa.el_ather.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AsMaa on 2/17/2018.
 */

public class fragment_Android extends Fragment {
RecyclerView mRecyclerView;
List<Model> data;
Adapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_android,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recy_android);
       LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        Log.d("debugMode", "The application stopped after this");
        mRecyclerView.setLayoutManager(mLayoutManager);
     data=new ArrayList<>();

        mAdapter = new Adapter(data);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
