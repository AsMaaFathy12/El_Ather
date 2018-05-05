package com.example.asmaa.el_ather.newIdea;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asmaa.el_ather.R;

import java.util.ArrayList;
import java.util.List;

public class IdeaActivity extends AppCompatActivity {

FloatingActionButton add;
    AlertDialog.Builder mdialog;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea);


        add=(FloatingActionButton)findViewById(R.id.fab);

        List<ideamodel> movies = new ArrayList<>();

        int img[] = {R.drawable.elather,R.drawable.elather,
                R.drawable.elather};

        String names[] = {"اعلان لمنتجات ألبان بشكل ابداعي" , "اعلان لمنتجات ألبان بشكل ابداعي", "اعلان لمنتجات ألبان بشكل ابداعي"};


        String content[] = {"إن أهم ما يرتكز عليه عمل دعاية وإعلان لمنتج أو لخدمة هي الابتكار والإبداع في الإعلان نفسه فلابد أن يتميز بأنه غير تقليدي ( إعلان مبتكر ) به فكرة إعلانية مجنونة تجذب الانتباه ومن الممكن أن تثير الدهشة والاستغراب لكن لا بأس المهم",
                "إن أهم ما يرتكز عليه عمل دعاية وإعلان لمنتج أو لخدمة هي الابتكار والإبداع في الإعلان نفسه فلابد أن يتميز بأنه غير تقليدي ( إعلان مبتكر ) به فكرة إعلانية مجنونة تجذب الانتباه ومن الممكن أن تثير الدهشة والاستغراب لكن لا بأس المهم هو تحقيق الهدف بمعنى توصيل الرسالة الإعلانية للمنتج أو للخدمة بصورة جذابة ترسخ في الأذهان","إن أهم ما يرتكز عليه عمل دعاية وإعلان لمنتج أو لخدمة هي الابتكار والإبداع في الإعلان نفسه فلابد أن يتميز بأنه غير تقليدي ( إعلان مبتكر ) به فكرة إعلانية مجنونة تجذب الانتباه ومن الممكن أن تثير الدهشة والاستغراب لكن لا بأس المهم ه"};


        for (int i = 0; i < img.length; i++) {

            ideamodel movie =
                    new ideamodel(names[i], content[i], img[i]);

            movies.add(movie);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.idea_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ideaAdapter adapter = new ideaAdapter(movies,this);
        recyclerView.setAdapter(adapter);
        mdialog = new AlertDialog.Builder(this);
        mdialog.setCancelable(false);
        mdialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IdeaActivity.this,addActivity.class);
                startActivity(i);
            }
        });


    }
//    private void loadFragment(Fragment mfragment)  {
//        FragmentManager fragmentManager=getFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//
//        fragmentTransaction.replace(R.id.contentFrame,mfragment);
//        fragmentTransaction.commit();
//    }
}
