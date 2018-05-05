package com.example.asmaa.el_ather.Employee;

/**
 * Created by AsMaa on 2/17/2018.
 */

public class Model {
    String name;
    String img;
    String email;
    String phone;

    public Model(String name, String img, String email, String phone) {
        this.name = name;
        this.img = img;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

