package com.example.asmaa.el_ather.About;

/**
 * Created by AsMaa on 3/11/2018.
 */

public class AboutModel {
    String title;
    String content;
    String img;
    String T_img;

    public AboutModel(String title, String content, String image, String image_title) {
this.content=content;
this.img=image;
this.title=title;
this.T_img=image_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getT_img() {
        return T_img;
    }

    public void setT_img(String t_img) {
        T_img = t_img;
    }
}
