package com.example.asmaa.el_ather.products.product_webDesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asmaa.el_ather.R;
import com.example.asmaa.el_ather.news.newsActivity;

import java.util.List;

/**
 * Created by AsMaa on 2/8/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements View.OnClickListener {
    private List<Model> newsmodel;
    private Context context;
    newsActivity news;
    public Adapter(List<Model> feedsList) {

        this.newsmodel = feedsList;



    }
    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mylist = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_webdesign,null);
        MyViewHolder holder=new MyViewHolder(mylist);
        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
        Model feeds = newsmodel.get(position);
        holder.title.setText(feeds.getTitle());
        holder.img.setImageResource((feeds.getImg()));



    }

    @Override
    public int getItemCount()
    {
        return newsmodel.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

         TextView  title;
         ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
           img=(ImageView) itemView.findViewById(R.id.android_img);
            title = (TextView) itemView.findViewById(R.id.android_txt);



        }
        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();
            Model feeds = newsmodel.get(position);

        }
    }


}
