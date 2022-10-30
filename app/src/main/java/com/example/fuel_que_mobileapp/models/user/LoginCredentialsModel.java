package com.example.fuel_que_mobileapp.models.user;

public class LoginCredentialsModel {
    private String Email;
    private String Password;

    public LoginCredentialsModel(String Email,String Password){
        this.Email = Email;
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
}
