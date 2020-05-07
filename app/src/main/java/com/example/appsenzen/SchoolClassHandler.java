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

    public static Timetable getTimetable() {
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
        return schoolClassNames.get(index);
    }

    public static SchoolClass getSchoolClass(int index) {
        return schoolClasses.get(index);
    }

    public static SchoolClass getSchoolClass(String name) {
        int index = schoolClassNames.indexOf(name);
        return schoolClasses.get(index);
    }

    public static boolean contains(String name) {
        return schoolClassNames.contains(name);
    }

    public static void clear() {

        for (SchoolClass s : schoolClasses) {
            s.clear();
        }

        schoolClasses = new ArrayList<>();
        schoolClassNames = new ArrayList<>();

        multiplier = 20;

        timetable = new Timetable();

        saveLists();
    }

    private static void saveObject(Object object, String name) {
        try {
            FileOutputStream fos = activityContext.openFileOutput(name, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object loadObject(String name) {
        Object object = null;

        try {
            FileInputStream fis = activityContext.openFileInput(name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            //ignore
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

    public static void saveLists() {
        saveObject(schoolClasses, "schoolClasses.ser");
        saveObject(schoolClassNames, "schoolClassNames.ser");
        saveObject(multiplier, "multiplier.ser");
        //saveObject(timetable, "timetable.ser");
    }

    public static void loadLists() {
        schoolClasses = (ArrayList<SchoolClass>) loadObject("schoolClasses.ser");
        schoolClassNames = (ArrayList<String>) loadObject("schoolClassNames.ser");
        multiplier = (Integer) loadObject("multiplier.ser");
        //timetable = (Timetable) loadObject("timetable.ser");
    }

}
