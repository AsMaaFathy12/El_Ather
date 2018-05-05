package com.example.asmaa.el_ather.offer;

/**
 * Created by AsMaa on 2/12/2018.
 */

public class offerModel {
    private String img;
    private String title;

    public offerModel(String off_img, String off_title) {
        this.img=off_img;
        this.title=off_title;

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
