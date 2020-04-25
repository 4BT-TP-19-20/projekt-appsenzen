package com.example.appsenzen;


import java.util.Date;

public class Lesson {
    private final String className;
    private final int day;
    private final Date lessonStart;
    private final Date lessonEnd;


    public Lesson(String className, int day, Date lessonStart, Date lessonEnd) {
        this.className = className;
        this.day = day;
        this.lessonStart = lessonStart;
        this.lessonEnd = lessonEnd;
    }

    public String getClassName() {
        return className;
    }

    public int getDay() {
        return day;
    }

    public Date getLessonStart() {
        return lessonStart;
    }

    public Date getLessonEnd() {
        return lessonEnd;
    }
}
