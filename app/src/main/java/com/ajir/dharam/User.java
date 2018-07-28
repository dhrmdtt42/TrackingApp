package com.ajir.dharam;

/**
 * Created by Dharam on 7/26/2018.
 */

public class User {

    int id;
    String name;
    String password;
    String phone_number;

    public User(){}
    public User(int id, String name, String password, String phone_number) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
