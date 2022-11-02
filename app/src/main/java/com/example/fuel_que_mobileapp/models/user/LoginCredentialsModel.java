package com.example.fuel_que_mobileapp.models.user;

public class LoginCredentialsModel {
    private int id;
    private String email;
    private String password;

    public LoginCredentialsModel(String Email,String Password){
        this.email = Email;
        this.password = Password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
