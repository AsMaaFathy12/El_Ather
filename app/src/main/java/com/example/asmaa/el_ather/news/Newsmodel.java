package com.example.asmaa.el_ather.news;


public class Newsmodel {



    public Newsmodel() {
    }

    public Newsmodel(String content, String title) {
        this.content_new=content;
        this.title_new=title;
    }

    public String getContent_new() {
        return content_new;
    }

    public void setContent_new(String content_new) {
        this.content_new = content_new;
    }

    public String getTitle_new() {
        return title_new;
    }

    public void setTitle_new(String title_new) {
        this.title_new = title_new;
    }

    private String content_new;
    private String title_new;




    }








