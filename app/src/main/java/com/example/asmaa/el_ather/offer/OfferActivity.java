package com.example.asmaa.el_ather.offer;

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
import com.example.asmaa.el_ather.news.Newsmodel;
import com.example.asmaa.el_ather.news.newsActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OfferActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RequestQueue queue;
    String JSON_URL = "https://alatheertech.com/api/find/comp_offers";
    List<offerModel> offerList = new ArrayList<offerModel>();
    Adapteroffer adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        recyclerView = (RecyclerView) findViewById(R.id.offerRecycler);
        adapter = new Adapteroffer(this, offerList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        recyclerView.setAdapter(adapter);
        queue=  NetworkController.getInstance(this).getRequestQueue();

        JsonArrayRequest response = new JsonArrayRequest( JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                offerModel feeds = new offerModel(obj.getString("off_img"), obj.getString("off_title"));
                                offerList.add(feeds);
                                recyclerView.setLayoutManager(new LinearLayoutManager(OfferActivity.this));
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
