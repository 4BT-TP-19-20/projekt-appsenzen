package com.example.appsenzen;


import java.util.ArrayList;
import java.util.Date;

public class Timetable {

    private final ArrayList<Lesson> lessons = new ArrayList<>();

    public void addLesson(String className, int day, Date lessonStart, Date lessonEnd){
        lessons.add(new Lesson(className, day, lessonStart ,lessonEnd));
    }

    public void removeLesson(String className, int day){
        for(Lesson l : lessons){
            if(l.getClassName().equals(className) && l.getDay() == day){
                lessons.remove(l);
            }
        }
    }

    public String getClassName(int day, Date time){

        return "";
    }
}
