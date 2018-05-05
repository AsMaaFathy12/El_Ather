package com.example.asmaa.el_ather.Service;

/**
 * Created by AsMaa on 2/12/2018.
 */

public class serviceModel {
    private String img;
    private String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;


    public serviceModel(String title, String img,String content) {
        this.img=img;
        this.title=title;
        this.content=content;

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
