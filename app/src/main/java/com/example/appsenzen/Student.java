package com.example.appsenzen;

public class Student {      //I spam oanfoch olles auf public noa mussi net long nochdenkn, und ändos noa aonfoch zum schluss xD
    private String name;
    private int totalPushups;
    private int remainingPushups;
    private String myMissingLog;        //Do schreibmo oanfoch olm wenn oaner fahlt
    private String className;

    public Student(String name, String className){
        this.name = name;
        this.totalPushups = 0;
        this.remainingPushups = 0;
        this.className=className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPushups() {
        return totalPushups;
    }

    public void setTotalPushups(int totalPushups) {
        this.totalPushups = totalPushups;
    }

    public int getRemainingPushups() {
        return remainingPushups;
    }

    public void setRemainingPushups(int remainingPushups) {
        this.remainingPushups = remainingPushups;
    }

    public void addPushups(int pushups){
        remainingPushups += pushups;
        totalPushups += pushups;
    }

    public void clearPushups(){
        remainingPushups = 0;
    }
}
