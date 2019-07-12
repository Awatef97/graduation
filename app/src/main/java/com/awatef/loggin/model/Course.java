package com.awatef.loggin.model;

import java.io.Serializable;

/**
 * Created by karim pc on 10/27/2017.
 */

public class Course implements Serializable {
    private String name;
    private String id;


    public Course(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Course() {
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


    @Override
    public String toString() {
        return "Course{" +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
