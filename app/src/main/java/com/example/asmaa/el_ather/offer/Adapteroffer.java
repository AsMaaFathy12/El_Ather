package com.example.asmaa.el_ather.offer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;
import com.example.asmaa.el_ather.news.Newsmodel;
import com.example.asmaa.el_ather.news.newsActivity;
import com.example.asmaa.el_ather.news.newsDetail;

import java.util.List;

/**
 * Created by AsMaa on 2/6/2018.
 */

public class Adapteroffer extends RecyclerView.Adapter<Adapteroffer.MyViewHolder> implements View.OnClickListener{

    private List<offerModel> offermodel;
    private Context context;



    public Adapteroffer(Context context, List<offerModel> feedsList) {

        this.context = context;
        this.offermodel = feedsList;


    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_offer, parent, false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        offerModel feeds = offermodel.get(position);
        holder.imageview.setImageUrl("https://alatheertech.com/uploads/images/"+feeds.getImg(), NetworkController.getInstance(context).getImageLoader());
        holder.title.setText(feeds.getTitle());



    }

    @Override
    public int getItemCount() {
        return offermodel.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        private TextView  title;
        private NetworkImageView imageview;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageview = (NetworkImageView) itemView.findViewById(R.id.img);
            title = (TextView) itemView.findViewById(R.id.txt_offer);



        }

    }

}