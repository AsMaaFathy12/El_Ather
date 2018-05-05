package com.example.asmaa.el_ather.newIdea;

import android.content.Context;
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

import java.util.List;

/**
 * Created by AsMaa on 2/8/2018.
 */

public class ideaAdapter extends RecyclerView.Adapter<ideaAdapter.MyViewHolder>  {
    private List<ideamodel>idea_model;
    private Context context;
    newsActivity news;
    public ideaAdapter(List<ideamodel> feedsList, Context context) {
        this.context=context;
        this.idea_model = feedsList;
        this.news=news;


    }
    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mylist = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_idea,null);
        MyViewHolder holder=new MyViewHolder(mylist);
        return holder;
    }

    @Override
    public void onBindViewHolder(ideaAdapter.MyViewHolder holder, int position) {
        ideamodel feeds = idea_model.get(position);
        holder.content.setText(feeds.content);
        holder.title.setText(feeds.name);
        holder.imageview.setImageUrl("https://alatheertech.com/uploads/images/"+feeds.img, NetworkController.getInstance(context).getImageLoader());




    }

    @Override
    public int getItemCount()
    {
        return idea_model.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView content,title;
        private NetworkImageView imageview;


        public MyViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.txt_con_idea);
            title = (TextView) itemView.findViewById(R.id.txt_name_idea);
            imageview = (NetworkImageView) itemView.findViewById(R.id.img_idea);

        }
        @Override
        public void onClick(View view) {

//            int position = (int) view.getTag();
//            Newsmodel   feeds = newsmodel.get(position);
//            Intent intent = new Intent(news, newsDetail.class);
//            intent.putExtra("title", feeds.getTitle_new());
//            intent.putExtra("content", feeds.getContent_new());
//            news.startActivity(intent);


        }
    }


}
