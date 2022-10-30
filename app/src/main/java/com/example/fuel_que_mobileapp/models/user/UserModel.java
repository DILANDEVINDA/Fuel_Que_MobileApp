package com.example.fuel_que_mobileapp.models.user;

public class UserModel {

    private String id;
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private String userType;

    public UserModel(String name, String email, String password, String mobilenumber, String usertype) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobilenumber;
        this.userType = usertype;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobilenumber() {
        return mobileNumber;
    }

    public String getUsertype() {
        return userType;
    }
}
