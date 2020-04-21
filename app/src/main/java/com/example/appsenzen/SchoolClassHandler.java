package com.example.appsenzen;

import java.util.ArrayList;

public abstract class SchoolClassHandler {
    private static final ArrayList<SchoolClass> schoolClasses = new ArrayList<>();
    private static int multiplier;

    public static void addSchoolClass(String name){
        SchoolClass schoolClass = new SchoolClass(name);
        if(!schoolClasses.contains(schoolClass)){
            schoolClasses.add(schoolClass);
        }
    }

    public static int getMultiplier() {
        return multiplier;
    }

    public static void setMultiplier(int multiplier) {
        SchoolClassHandler.multiplier = multiplier;
    }
}
