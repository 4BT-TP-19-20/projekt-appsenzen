package com.example.appsenzen;

import java.util.ArrayList;

public abstract class SchoolClassHandler {
    private final ArrayList<SchoolClass> schoolClasses = new ArrayList<>();

    public void addSchoolClass(String name){
        SchoolClass schoolClass = new SchoolClass(name);
        if(!schoolClasses.contains(schoolClass)){
            schoolClasses.add(schoolClass);
        }
    }


}
