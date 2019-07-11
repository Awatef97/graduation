package com.awatef.loggin;

/**
 * Created by awatef on 7/6/2019.
 */

import java.util.List;

public class NamesModel {

    private String name;
    private List<NamesModel> names;

    public String getName(){

        return name;
    }
    public void setNames(String name){
        this.name=name;
    }
    public List<NamesModel> getNames() {
        return names;
    }
}
