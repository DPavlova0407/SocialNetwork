package com.example.a13_da.socialnetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 13_da on 11.04.2018.
 */

public class Session {
    private static Session INSTANCE = new Session();
    private Session(){}
    public static Session getINSTANCE(){return INSTANCE;}

    private User currentUser = new User("Admin", "Adminov", "Adminovich",
            "admin@gmail.com", "+79045867658", "Неопределен",
            "Admin", "000");
    private List<User> userList = new ArrayList<>();
    private Map<String, User> userMap = new HashMap<>();

    private List<User> male = new ArrayList<>();
    private List<User> female = new ArrayList<>();
    private List<User> not_defined = new ArrayList<>();


    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void addUser(User user) {
        userList.add(user);
        userMap.put(user.getLogin(), user);
        if (user.getGender().equals("Женский"))
            female.add(user);
        else {
            if (user.getGender().equals("Мужской"))
                male.add(user);
            else
                not_defined.add(user);
        }
    }

    public List<User> getMale() {
        return male;
    }

    public List<User> getFemale() {
        return female;
    }

    public List<User> getNot_defined() {
        return not_defined;
    }

    public User getCurrentUser() {
        return currentUser;
    }
    public List<User> getUsersList() {
        return userList;
    }
    public Map<String, User> getUsersMap() {
        return userMap;
    }
}
