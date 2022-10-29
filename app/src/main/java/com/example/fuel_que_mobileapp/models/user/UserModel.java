package com.example.fuel_que_mobileapp.models.user;

public class UserModel {

    private String id;
    private String name;
    private String email;
    private String password;
    private String mobilenumber;
    private String usertype;

    public UserModel(String name, String email, String password, String mobilenumber, String usertype) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobilenumber = mobilenumber;
        this.usertype = usertype;
    }

}
