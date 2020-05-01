package com.example.appsenzen;

import java.io.Serializable;

public class Student implements Serializable {
    private final String name;
    private int totalPushups;
    private int remainingPushups;
    private SchoolClass schoolClass;
    private String myMissingLog;        //Do schreibmo oanfoch olm wenn oaner fahlt


    public Student(String name, SchoolClass schoolClass){
        this.name = name;
        this.totalPushups = 0;
        this.remainingPushups = 0;
        this.schoolClass = schoolClass;
    }

    public String getName() {
        return name;
    }

    public SchoolClass getSchoolClass(){
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass){
        this.schoolClass = schoolClass;
    }

    public int getTotalPushups() {
        return totalPushups;
    }

    public int getRemainingPushups() {
        return remainingPushups;
    }

    public String getLog(){
        return myMissingLog;
    }

    public void addPushups(int pushups){
        remainingPushups += pushups;
        totalPushups += pushups;
    }

    public void clearPushups(){
        remainingPushups = 0;
    }
}
