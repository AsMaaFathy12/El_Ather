package com.example.asmaa.el_ather.Employee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;
import com.example.asmaa.el_ather.news.newsActivity;

import java.util.List;

/**
 * Created by AsMaa on 2/8/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements View.OnClickListener {
    private List<Model> emodel;
    private Context context;

    public Adapter(List<Model> feedsList) {

        this.emodel = feedsList;



    }
    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mylist = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee,null);
        MyViewHolder holder=new MyViewHolder(mylist);
        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
        Model feeds = emodel.get(position);
        holder.name.setText(feeds.getName());
        holder.imageview.setImageUrl("https://alatheertech.com/uploads/images/"+feeds.getImg(), NetworkController.getInstance(context).getImageLoader());
        holder.email.setText(feeds.getEmail());
        holder.phone.setText(feeds.getPhone());


    }

    @Override
    public int getItemCount()
    {
        return emodel.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

         TextView  name,email,phone;
        private NetworkImageView imageview;


        public MyViewHolder(View itemView) {
            super(itemView);
            imageview = (NetworkImageView) itemView.findViewById(R.id.prof_img);
            name = (TextView) itemView.findViewById(R.id.prof_name);
            email = (TextView) itemView.findViewById(R.id.prof_email);
            phone = (TextView) itemView.findViewById(R.id.prof_phone);



        }
        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();
            Model feeds = emodel.get(position);

        }
    }


}
