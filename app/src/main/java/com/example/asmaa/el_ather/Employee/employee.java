package com.example.asmaa.el_ather.Employee;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;



import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AsMaa on 3/5/2018.
 */

public class employee extends Fragment {
    RecyclerView mRecyclerView;
    RequestQueue queue;
    String JSON_URL = "http://alatheertech.com/api/find/employees";
    List<Model> data;
    Adapter mAdapter;
    LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fra_employee,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recy_employee);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
      //   mLayoutManager=new GridLayoutManager(this.getContext(),2);
      //  mRecyclerView.setLayoutManager(mLayoutManager);
        data=new ArrayList<>();
        mAdapter = new Adapter(data);
     //   mRecyclerView.setAdapter(mAdapter);
        queue=  NetworkController.getInstance(getContext()).getRequestQueue();

        JsonArrayRequest response = new JsonArrayRequest( JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Model feeds = new Model(obj.getString("name"), obj.getString("image"),obj.getString("address"),obj.getString("telephone"));


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

