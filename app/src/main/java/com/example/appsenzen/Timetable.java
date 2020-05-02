package com.example.appsenzen;


import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Timetable {

    private final ArrayList<Lesson> lessons = new ArrayList<>();

    public void addLesson(String className, int day, int lesson) {
        lessons.add(new Lesson(className, day, lesson));
    }

    public void addLesson(String className, int day, Date lessonStart, Date lessonEnd) {
        lessons.add(new Lesson(className, day, lessonStart, lessonEnd));
    }

    public void removeLesson(String className, int day) {
        for (Lesson l : lessons) {
            if (l.getClassName().equals(className) && l.getDay() == day) {
                lessons.remove(l);
            }
        }
    }

    public String getClassName(int day, Date date) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date time = null;

        try {
            time = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        for (Lesson l : lessons) {
            if (day != l.getDay()) {
                continue;
            }

            assert time != null;
            if (time.after(l.getLessonStart()) && time.before(l.getLessonEnd())) {
                return l.getClassName();
            }

        }

        return "";
    }

    public Lesson getLesson(String className, int day){
        for (Lesson l : lessons) {
            if (l.getClassName().equals(className) && l.getDay() == day) {
                return l;
            }
        }

        return null;
    }
}
