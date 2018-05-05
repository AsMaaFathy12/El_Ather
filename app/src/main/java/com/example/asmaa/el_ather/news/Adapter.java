package com.example.asmaa.el_ather.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asmaa.el_ather.R;

import java.util.List;

/**
 * Created by AsMaa on 2/8/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>  {
    private List<Newsmodel> newsmodel;
    private Context context;
    newsActivity news;
    public Adapter( List<Newsmodel> feedsList,newsActivity news,Context context) {
        this.context=context;
        this.newsmodel = feedsList;
        this.news=news;


    }
    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mylist = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new,null);
        MyViewHolder holder=new MyViewHolder(mylist);
        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
        Newsmodel feeds = newsmodel.get(position);
        holder.cardView.setTag(position);
        holder.content.setText(feeds.getContent_new());
        holder.title.setText(feeds.getTitle_new());



    }

    @Override
    public int getItemCount()
    {
        return newsmodel.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView;
        TextView content,title;

        public MyViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.txt_content);
            title = (TextView) itemView.findViewById(R.id.txt_title);
            cardView = (CardView) itemView.findViewById(R.id.Card);

            cardView.setOnClickListener(this);
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
