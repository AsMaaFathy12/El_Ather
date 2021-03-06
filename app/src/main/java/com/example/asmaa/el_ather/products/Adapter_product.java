package com.example.asmaa.el_ather.products;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.asmaa.el_ather.NetworkController;
import com.example.asmaa.el_ather.R;
import com.example.asmaa.el_ather.departsss.dept_model;

import java.util.List;

/**
 * Created by AsMaa on 2/6/2018.
 */

public class Adapter_product extends RecyclerView.Adapter<Adapter_product.MyViewHolder> implements View.OnClickListener{

    private List<product_model> productModel;
    private Context context;



    public Adapter_product(Context context, List<product_model> feedsList) {

        this.context = context;
        this.productModel = feedsList;


    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        product_model feeds = productModel.get(position);
        holder.imageview.setImageUrl("https://alatheertech.com/uploads/images/"+feeds.getImg(), NetworkController.getInstance(context).getImageLoader());
        holder.title.setText(feeds.getTitle());



    }

    @Override
    public int getItemCount() {
        return productModel.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        private TextView  title;
        private NetworkImageView imageview;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageview = (NetworkImageView) itemView.findViewById(R.id.img_productt);
            title = (TextView) itemView.findViewById(R.id.txt_productt);



        }

    }

}