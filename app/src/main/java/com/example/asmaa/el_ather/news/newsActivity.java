package com.example.asmaa.el_ather.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.asmaa.el_ather.Controller;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class newsActivity extends AppCompatActivity {
    private static final String JSON_URL = "http://alatheertech.com/api/find/news";
    RecyclerView recyclerView;
    ArrayList<Newsmodel>  newsList = new ArrayList<>();
    Adapter adapter;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


       adapter = new Adapter( newsList,this,this);

       queue=  NetworkController.getInstance(this).getRequestQueue();

        JsonArrayRequest response = new JsonArrayRequest( JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Newsmodel feeds = new Newsmodel(obj.getString("content"), obj.getString("title"));


                                newsList.add(feeds);
                                recyclerView.setLayoutManager(new LinearLayoutManager(newsActivity.this));
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
