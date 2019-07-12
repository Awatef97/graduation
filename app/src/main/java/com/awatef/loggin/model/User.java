package com.awatef.loggin.model;

import java.io.Serializable;

/**
 * Created by karim pc on 10/27/2017.
 */

public class User implements Serializable {
    private String email;
    private String name;
    private String id;
    private String type;

    public User(String email, String id) {
        this.email = email;
        this.id = id;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
