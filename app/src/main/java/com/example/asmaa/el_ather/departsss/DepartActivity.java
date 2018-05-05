package com.example.asmaa.el_ather.departsss;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;
import com.example.asmaa.el_ather.departsss.rec_android.fragment_Android;
import com.example.asmaa.el_ather.departsss.rec_webdesign.fragment_WebDesign;
import com.example.asmaa.el_ather.offer.Adapteroffer;
import com.example.asmaa.el_ather.offer.OfferActivity;
import com.example.asmaa.el_ather.offer.offerModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DepartActivity extends AppCompatActivity {
//Button android,webdesign,webdwvelop;
RecyclerView recyclerView;
    RequestQueue queue;
    String JSON_URL = "http://alatheertech.com/api/find/departments";
    List<dept_model> dept_List = new ArrayList<dept_model>();
    AdapterDept adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depart);
        recyclerView = (RecyclerView) findViewById(R.id.dept_Recycler);
        adapter = new AdapterDept(this, dept_List);
        queue=  NetworkController.getInstance(this).getRequestQueue();
        JsonArrayRequest response = new JsonArrayRequest( JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                dept_model feeds = new dept_model(obj.getString("title"), obj.getString("content"));
                                dept_List.add(feeds);
                                recyclerView.setLayoutManager(new LinearLayoutManager(DepartActivity.this));
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





//        android =(Button)findViewById(R.id.btn_android);
//        webdesign =(Button)findViewById(R.id.btn_webdesign);
//        webdwvelop =(Button)findViewById(R.id.btn_webdevelop);
//        android.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new fragment_Android());
//            }
//        });
//        webdesign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new fragment_WebDesign());
//            }
//        });
//    }
//
//
//    private void loadFragment(Fragment mfragment)  {
//        FragmentManager fragmentManager=getFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//
//        fragmentTransaction.replace(R.id.contentFrame,mfragment);
//        fragmentTransaction.commit();
    }
}

