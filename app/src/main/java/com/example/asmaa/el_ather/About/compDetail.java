package com.example.asmaa.el_ather.About;


import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.asmaa.el_ather.Employee.Adapter;
import com.example.asmaa.el_ather.Employee.Model;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by AsMaa on 2/15/2018.
 */

public class compDetail extends Fragment {
    RecyclerView mRecyclerView;
    RequestQueue queue;
    String JSON_URL = "http://alatheertech.com/api/find/about";
    List<AboutModel> data;
    AdapterAbout mAdapter;
    LinearLayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.about_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rec_About);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        //   mLayoutManager=new GridLayoutManager(this.getContext(),2);
        //  mRecyclerView.setLayoutManager(mLayoutManager);
        data=new ArrayList<>();
        mAdapter = new AdapterAbout(getContext(),data);
        //   mRecyclerView.setAdapter(mAdapter);
        queue=  NetworkController.getInstance(getContext()).getRequestQueue();

        JsonArrayRequest response = new JsonArrayRequest( JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                AboutModel feeds = new AboutModel(obj.getString("title"), obj.getString("content"),obj.getString("image"),obj.getString("image_title"));


                                data.add(feeds);
                                mRecyclerView.setLayoutManager(mLayoutManager);
                                mRecyclerView.setAdapter(mAdapter);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            } finally {

                                mAdapter.notifyItemChanged(i);

                            }
                        }
                    }
                },    new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        });
        queue.add(response);
        return view;
    }
}
