package com.awatef.loggin;

/**
 * Created by awatef on 6/30/2019.
 */

public class GradeTable {
    String name;
    int quiz1;
    int quiz2;
    int mid;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getQuiz1(){
        return quiz1;
    }
    public void setQuiz1(int quiz1){
        this.quiz1=quiz1;
    }
    public int getQuiz2(){
        return quiz2;
    }
    public void setQuiz2(int quiz2){
        this.quiz2=quiz2;
    }
    public int getMid(){
        return mid;
    }
    public void setMid(int mid){
        this.mid=mid;
    }



   /* public GradeTable(String name, int quiz1, int quiz2, int mid) {
        this.name=name;
        this.quiz1=quiz1;
        this.quiz2=quiz2;
        this.mid=mid;
  }
  **/
}
