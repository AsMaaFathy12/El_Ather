package com.example.asmaa.el_ather.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.asmaa.el_ather.R;

public class newsDetail extends AppCompatActivity {
    TextView content,title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        content=(TextView)findViewById(R.id.content);
        title=(TextView)findViewById(R.id.title);

        Intent intent=getIntent();
        content.setText(intent.getStringExtra("content"));
        title.setText(intent.getStringExtra("title"));
    }
}
