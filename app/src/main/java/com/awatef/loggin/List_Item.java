package com.awatef.loggin;





public class List_Item {

    public int id;
    public String story;
    public String img_link;

    public List_Item(int id, String story, String img_link) {
        this.id = id;
        this.story = story;
        this.img_link = img_link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }
}

