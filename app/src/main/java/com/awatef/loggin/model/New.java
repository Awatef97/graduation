package com.awatef.loggin.model;

import java.io.Serializable;

public class New implements Serializable {
    private String description;
    private String imageUrl;

    private String id;

    public New() {
    }

    public New(String description, String imageUrl, String id) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "New{" +
                "description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
