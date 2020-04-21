package com.example.appsenzen;


import java.util.ArrayList;

public abstract class SchoolClassHandler {

    private static ArrayList<SchoolClass> schoolClasses = new ArrayList<>();
    private static ArrayList<String> schoolClassNames = new ArrayList<>();

    private static int multiplier;

    public static int getMultiplier() {
        return multiplier;
    }

    public static void setMultiplier(int multiplier) {
        SchoolClassHandler.multiplier = multiplier;
    }

    public static void addSchoolClass(SchoolClass schoolClass) {
        String name = schoolClass.getClassName();
        if (!schoolClasses.contains(schoolClass) && !schoolClassNames.contains(name)) {
            schoolClasses.add(schoolClass);
            schoolClassNames.add(name);
        }
    }

    public static void addSchoolClass(String name) {
        SchoolClass schoolClass = new SchoolClass(name);
        addSchoolClass(schoolClass);
    }

    public static void removeSchoolClass(SchoolClass schoolClass) {
        String name = schoolClass.getClassName();

        schoolClasses.remove(schoolClass);
        schoolClassNames.remove(name);
    }

    public static void removeSchoolClass(String name) {
        int index = schoolClassNames.indexOf(name);

        schoolClasses.remove(index);
        schoolClassNames.remove(index);
    }

    public static int getListSize() {
        return schoolClasses.size();
    }

    public static String getNameByIndex(int index) {
        return schoolClasses.get(index).getClassName();
    }

    public static SchoolClass getSchoolClass(int index) {
        return schoolClasses.get(index);
    }

    public static SchoolClass getSchoolClass(String name) {
        int index = schoolClassNames.indexOf(name);
        return schoolClasses.get(index);
    }

}
