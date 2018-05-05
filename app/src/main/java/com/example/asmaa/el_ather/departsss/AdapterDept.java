package com.example.asmaa.el_ather.departsss;

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

public class AdapterDept extends RecyclerView.Adapter<AdapterDept.MyViewHolder> implements View.OnClickListener{

    private List<dept_model> deptmodel;
    private Context context;



    public AdapterDept(Context context, List<dept_model> feedsList) {

        this.context = context;
        this.deptmodel = feedsList;


    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_depart, parent, false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        dept_model feeds = deptmodel.get(position);
       // holder.imageview.setImageUrl("https://alatheertech.com/uploads/images/"+feeds.getImg(), NetworkController.getInstance(context).getImageLoader());
        holder.title.setText(feeds.getTitle());
        holder.content.setText(feeds.getContent());



    }

    @Override
    public int getItemCount() {
        return deptmodel.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        private TextView  title ,content;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txt_dept);
            content = (TextView) itemView.findViewById(R.id.txt_con_deptt);




        }

    }

}