package com.example.asmaa.el_ather;




import android.content.Intent;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.asmaa.el_ather.Service.ServiceActivity;
import com.example.asmaa.el_ather.departsss.DepartActivity;
import com.example.asmaa.el_ather.newIdea.IdeaActivity;
import com.example.asmaa.el_ather.news.newsActivity;
import com.example.asmaa.el_ather.offer.OfferActivity;
import com.example.asmaa.el_ather.products.productActivity;


/**
 * Created by AsMaa on 2/6/2018.
 */

public class HomeFragment extends Fragment {


    private RelativeLayout dept,product,service,offer,news,idea;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_shortcuts, container, false);

        dept = (RelativeLayout) rootView.findViewById(R.id.depart);
        product = (RelativeLayout) rootView.findViewById(R.id.products);
        service = (RelativeLayout) rootView.findViewById(R.id.services);
        offer = (RelativeLayout) rootView.findViewById(R.id.offers);
        news = (RelativeLayout) rootView.findViewById(R.id.nnew);
        idea = (RelativeLayout) rootView.findViewById(R.id.ideas);

        dept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i = new Intent(rootView.getContext(), DepartActivity.class);
                startActivity(i);

            }
        });
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent(rootView.getContext(), productActivity.class);
                startActivity(z);



            }
        });
          service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(rootView.getContext(),ServiceActivity.class);
                startActivity(y);

            }
        });
        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(rootView.getContext(),OfferActivity.class);
                startActivity(y);

            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(rootView.getContext(),newsActivity.class);
                startActivity(x);

            }
        });
        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(rootView.getContext(),IdeaActivity.class);
                startActivity(y);

            }
        });

        return rootView;
    }




    }

