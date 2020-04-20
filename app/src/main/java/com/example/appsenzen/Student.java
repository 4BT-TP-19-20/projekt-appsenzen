package com.example.appsenzen;

public class Student {      //I spam oanfoch olles auf public noa mussi net long nochdenkn, und ändos noa aonfoch zum schluss xD
    private final String name;
    private int totalPushups;
    private int remainingPushups;
    private SchoolClass schoolClass;
    private String myMissingLog;        //Do schreibmo oanfoch olm wenn oaner fahlt


    public Student(String name){
        this.name = name;
        this.totalPushups = 0;
        this.remainingPushups = 0;
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

    public void addPushups(int pushups){
        remainingPushups += pushups;
        totalPushups += pushups;
    }

    public void clearPushups(){
        remainingPushups = 0;
    }
}
