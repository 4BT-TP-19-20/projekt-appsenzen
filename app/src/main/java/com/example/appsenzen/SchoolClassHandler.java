package com.example.appsenzen;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.*;
import java.util.ArrayList;

public abstract class SchoolClassHandler {

    private static ArrayList<SchoolClass> schoolClasses = new ArrayList<>();
    private static ArrayList<String> schoolClassNames = new ArrayList<>();

    private static int multiplier;

    @SuppressLint("StaticFieldLeak")
    private static Context activityContext;

    private static Timetable timetable = new Timetable();


    public static int getMultiplier() {
        return multiplier;
    }

    public static void setMultiplier(int multiplier) {
        SchoolClassHandler.multiplier = multiplier;

        saveLists();
    }

    public static void setActivityContext(Context context) {
        activityContext = context;
    }

    public static Timetable getTimetable(){
        return timetable;
    }

    public static void addSchoolClass(SchoolClass schoolClass) {
        String name = schoolClass.getClassName();
        if (!schoolClasses.contains(schoolClass) && !schoolClassNames.contains(name)) {
            schoolClasses.add(schoolClass);
            schoolClassNames.add(name);

            saveLists();
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

        saveLists();
    }

    public static void removeSchoolClass(String name) {
        int index = schoolClassNames.indexOf(name);

        schoolClasses.remove(index);
        schoolClassNames.remove(index);

        saveLists();
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

    public static void clear(){

        for(SchoolClass s : schoolClasses){
            s.clear();
        }

        schoolClasses = new ArrayList<>();
        schoolClassNames = new ArrayList<>();
        multiplier = 20;
        saveLists();
    }

    public static void saveLists() {
        try {
            FileOutputStream fos = activityContext.openFileOutput("schoolClasses.ser", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(schoolClasses);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fos = activityContext.openFileOutput("schoolClassNames.ser", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(schoolClassNames);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fos = activityContext.openFileOutput("multiplier.ser", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(multiplier);
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fos = activityContext.openFileOutput("timetable.ser", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(timetable);
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadLists() {
        try {
            FileInputStream fis = activityContext.openFileInput("schoolClasses.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            schoolClasses = (ArrayList<SchoolClass>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            //ignore
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = activityContext.openFileInput("schoolClassNames.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            schoolClassNames = (ArrayList<String>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            //ignore
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = activityContext.openFileInput("multiplier.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            multiplier = (Integer) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            //ignore
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = activityContext.openFileInput("timetable.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            timetable = (Timetable) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            //ignore
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
