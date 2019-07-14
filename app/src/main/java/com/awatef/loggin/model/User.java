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
    private int attendence;

    public User() {
    }

    public User(String email, String name, String id, String type, int attendence) {
        this.email = email;
        this.name = name;
        this.id = id;
        this.type = type;
        this.attendence = attendence;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", attendence=" + attendence +
                '}';
    }
}
