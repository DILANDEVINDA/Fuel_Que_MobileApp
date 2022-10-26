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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
