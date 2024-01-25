package com.safe.canti;

import android.widget.ImageView;

public class Model {




    String name;
    String email;
    String phone;
    String fromplace;
    String time;
    String car ;
    String pass ;

    Model()
    {


    }

    public Model(String name, String email, String phone, String fromplace, String toplace, String date, String time, String car, String pass) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.fromplace = fromplace;
        this.toplace = toplace;
        this.date = date;
        this.time = time;
        this.car = car;
        this.pass = pass;
    }

    String toplace;
    String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFromplace() {
        return fromplace;
    }

    public void setFromplace(String fromplace) {
        this.fromplace = fromplace;
    }

    public String getToplace() {
        return toplace;
    }

    public void setToplace(String toplace) {
        this.toplace = toplace;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }





 //   ImageView call ,delete;





}
