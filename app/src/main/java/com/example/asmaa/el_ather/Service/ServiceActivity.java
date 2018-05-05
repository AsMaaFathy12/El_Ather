package com.example.asmaa.el_ather.Service;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;
import com.example.asmaa.el_ather.offer.Adapteroffer;
import com.example.asmaa.el_ather.offer.OfferActivity;
import com.example.asmaa.el_ather.offer.offerModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ServiceActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RequestQueue queue;
    String JSON_URL = "https://alatheertech.com/api/find/department_services";
    List<serviceModel> serviceList = new ArrayList<serviceModel>();
    Adapterservice adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        recyclerView = (RecyclerView) findViewById(R.id.offerRecycler);
        adapter = new Adapterservice(this, serviceList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
        queue=  NetworkController.getInstance(this).getRequestQueue();

        JsonArrayRequest response = new JsonArrayRequest( JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                serviceModel feeds = new serviceModel( obj.getString("title"),obj.getString("img"),obj.getString("content"));
                                serviceList.add(feeds);
                                recyclerView.setLayoutManager(new LinearLayoutManager(ServiceActivity.this));
                                recyclerView.setAdapter(adapter);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            } finally {

                                adapter.notifyItemChanged(i);

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
    }
}
