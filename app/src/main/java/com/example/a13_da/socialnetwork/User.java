package com.example.a13_da.socialnetwork;

import android.graphics.drawable.Drawable;

/**
 * Created by 13_da on 29.03.2018.
 */

public class User {
    private String name;
    private String surname;
    private String mail;
    private String phone;

    private Drawable photo;

    private String login;
    private String password;

    public User(String name, String surname, String mail, String phone){
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
    }

    public void setLogin(String login) {this.login = login;}
    public void setPassword(String password) {this.password = password;}

    @Override
    public String toString() {
        return name + '\n' +
                surname + '\n' +
                mail + '\n' +
                phone + '\n' +
                login + '\n' +
                password + '\n';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }
}
