package com.example.asmaa.el_ather.About;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;
import com.example.asmaa.el_ather.offer.offerModel;

import java.util.List;

/**
 * Created by AsMaa on 2/6/2018.
 */

public class AdapterAbout extends RecyclerView.Adapter<AdapterAbout.MyViewHolder> implements View.OnClickListener{

    private List<AboutModel> aboutmodel;
    private Context context;



    public AdapterAbout(Context context, List<AboutModel> feedsList) {

        this.context = context;
        this.aboutmodel = feedsList;


    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_about, parent, false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AboutModel feeds = aboutmodel.get(position);
        holder.imageview.setImageUrl("https://alatheertech.com/uploads/images/"+feeds.getImg(), NetworkController.getInstance(context).getImageLoader());
        holder.t_img.setImageUrl("https://alatheertech.com/uploads/images/"+feeds.getT_img(), NetworkController.getInstance(context).getImageLoader());

        holder.title.setText(feeds.getTitle());
        holder.content.setText(feeds.getContent());



    }

    @Override
    public int getItemCount() {
        return aboutmodel.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        private TextView  title,content;
        private NetworkImageView imageview,t_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageview = (NetworkImageView) itemView.findViewById(R.id.img_about);
            t_img = (NetworkImageView) itemView.findViewById(R.id.img_title_about);
            title = (TextView) itemView.findViewById(R.id.txt_title);
            content = (TextView) itemView.findViewById(R.id.txt_content);



        }

    }

}