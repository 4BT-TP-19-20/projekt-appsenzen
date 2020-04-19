package com.example.appsenzen;

public class Student {      //I spam oanfoch olles auf public noa mussi net long nochdenkn, und ändos noa aonfoch zum schluss xD
    public String name;
    public int totalPushups;
    public int remainingPushups;

    Student(String name){
        this.name = name;
        this.totalPushups = 0;
        this.remainingPushups = 0;
    }

    public void addPushups(int pushups){
        remainingPushups += pushups;
        totalPushups += pushups;
    }

    public void clearPushups(){
        remainingPushups = 0;
    }
}
