package com.cs.assignment2.Models;

import android.widget.CheckBox;

public class BasicInfo {
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String address;
    private String gender;
   // private CheckBox license;

    public BasicInfo() {
    }

    public BasicInfo(String fname, String lname, String email, String phone, String address,
                     String gender) {
        this.fname=fname;
        this.lname=lname;
        this.email=email;
        this.phone=phone;
        this.address=address;
        this.gender=gender;
       // this.license=license;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public CheckBox isLicense() {
//        return license;
//    }
//
//    public void setLicense(CheckBox license) {
//        this.license = license;
//    }
}