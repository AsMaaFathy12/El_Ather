package com.example.asmaa.el_ather.Service;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;

import java.util.List;

/**
 * Created by AsMaa on 2/6/2018.
 */

public class Adapterservice extends RecyclerView.Adapter<Adapterservice.MyViewHolder> {

    private List<serviceModel> service_model;
    private Context context;



    public Adapterservice(Context context, List<serviceModel> feedsList) {

        this.context = context;
        this.service_model = feedsList;


    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service, parent, false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        serviceModel feeds = service_model.get(position);
        holder.imageview.setImageUrl("https://alatheertech.com/uploads/images/"+feeds.getImg(), NetworkController.getInstance(context).getImageLoader());
        holder.title.setText(feeds.getTitle());
        holder.content.setText(feeds.getContent());



    }

    @Override
    public int getItemCount() {
        return service_model.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{


        private TextView  title,content;
        private NetworkImageView imageview;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageview = (NetworkImageView) itemView.findViewById(R.id.img_serv);
            title = (TextView) itemView.findViewById(R.id.txt_title_serv);
            content = (TextView) itemView.findViewById(R.id.txt_content_serv);




        }

    }

}