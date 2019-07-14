package com.awatef.loggin.model;

import java.io.Serializable;


public class SubjectTable implements Serializable {
    private String name;
    private int imageUrl;


    public SubjectTable() {
    }

    public SubjectTable(String name, int imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "SubjectTable{" +
                "name='" + name + '\'' +
                ", imageUrl=" + imageUrl +
                '}';
    }
}
