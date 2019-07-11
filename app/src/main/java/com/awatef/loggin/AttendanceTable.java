package com.awatef.loggin;

/**
 * Created by awatef on 6/30/2019.
 */

public class AttendanceTable {
    String name;
    boolean b1, b2, b3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        this.b1 = b1;
    }

    public boolean getB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        this.b2 = b2;
    }

    public boolean getB3() {
        return b3;
    }

    public void setB3(boolean b3) {
        this.b3 = b3;
    }

    public AttendanceTable(String name, boolean b1, boolean b2, boolean b3){
        this.name=name;
        this.b1=b1;
        this.b2=b2;
        this.b3=b3;
    }}

