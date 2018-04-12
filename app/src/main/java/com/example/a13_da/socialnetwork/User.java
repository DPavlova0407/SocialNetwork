package com.example.a13_da.socialnetwork;

import android.graphics.drawable.Drawable;

/**
 * Created by 13_da on 29.03.2018.
 */

public class User {
    private String name;
    private String surname;
    private String patronymic;
    private String mail;
    private String phone;
    private String gender;

    private String login;
    private String password;

    //   private int photo;

    public User(String name, String surname, String patronymic, String mail, String phone, String gender, String login, String password){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mail = mail;
        this.phone = phone;
        this.gender= gender;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

   /* public int getPhoto() {
        return photo;
    }*/

    @Override
    public String toString() {
        return name + '\n' +
                surname + '\n' +
                patronymic + '\n' +
                mail + '\n' +
                phone + '\n' +
                gender + '\n' +
                login + '\n' +
                password + '\n'; /*+
                photo + '\n';*/
    }
}
