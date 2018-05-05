package com.example.asmaa.el_ather.products;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;
import com.example.asmaa.el_ather.departsss.AdapterDept;
//import com.example.asmaa.el_ather.departsss.DepartActivity;
//import com.example.asmaa.el_ather.departsss.dept_model;
//import com.example.asmaa.el_ather.products.product_android.fragment_productAndroid;
//import com.example.asmaa.el_ather.products.product_webDesign.fragment_productWebDesign;
//import com.example.asmaa.el_ather.products.product_webDevelop.fragment_productWebDevelop;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class productActivity extends AppCompatActivity {
//ImageView android,webDesign,webDevelop;
RecyclerView recyclerView;
    RequestQueue queue;
    String JSON_URL = "http://alatheertech.com/api/find/products";
    List<product_model> product_List = new ArrayList<product_model>();
    Adapter_product adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recyclerView = (RecyclerView) findViewById(R.id.prod_Recycler);
        adapter = new Adapter_product(this, product_List);
        queue=  NetworkController.getInstance(this).getRequestQueue();

        JsonArrayRequest response = new JsonArrayRequest( JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                product_model feeds = new product_model(obj.getString("product_name"), obj.getString("product_image"));
                                product_List.add(feeds);
                                recyclerView.setLayoutManager(new LinearLayoutManager(productActivity.this));
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



//        android=(ImageView)findViewById(R.id.img_android);
//        webDesign=(ImageView)findViewById(R.id.img_webdesign);
//        webDevelop=(ImageView)findViewById(R.id.img_webdevelop);
//        android.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new fragment_productAndroid());
//            }
//        });
//        webDesign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new fragment_productWebDesign());
//            }
//        });
//        webDevelop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new fragment_productWebDevelop());
//            }
//        });
//    }
//    private void loadFragment(Fragment mfragment)  {
//        FragmentManager fragmentManager=getFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//
//        fragmentTransaction.replace(R.id.contentFrame,mfragment);
//        fragmentTransaction.commit();
//    }
    }}

