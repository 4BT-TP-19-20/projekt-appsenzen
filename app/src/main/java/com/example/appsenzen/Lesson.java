package com.example.appsenzen;


import android.annotation.SuppressLint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lesson {
    private final String className;
    private final int day;
    private Date lessonStart;
    private Date lessonEnd;

    public Lesson(String className, int day, int lesson) {
        this.className = className;
        this.day = day;

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        try {
            switch (lesson) {
                case 1:
                    lessonStart = sdf.parse("07:50");
                    lessonEnd = sdf.parse("08:40");
                    break;
                case 2:
                    lessonStart = sdf.parse("08:40");
                    lessonEnd = sdf.parse("09:30");
                    break;
                case 3:
                    lessonStart = sdf.parse("09:35");
                    lessonEnd = sdf.parse("10:25");
                    break;
                case 4:
                    lessonStart = sdf.parse("10:25");
                    lessonEnd = sdf.parse("11:15");
                    break;
                case 5:
                    lessonStart = sdf.parse("11:30");
                    lessonEnd = sdf.parse("12:20");
                    break;
                case 6:
                    lessonStart = sdf.parse("12:20");
                    lessonEnd = sdf.parse("13:10");
                    break;
                case 7:
                    lessonStart = sdf.parse("14:10");
                    lessonEnd = sdf.parse("15:00");
                    break;
                case 8:
                    lessonStart = sdf.parse("15:00");
                    lessonEnd = sdf.parse("15:50");
                    break;
                case 9:
                    lessonStart = sdf.parse("15:50");
                    lessonEnd = sdf.parse("16:40");
                    break;
                default:
                    //should never happen
                    lessonStart = new Date();
                    lessonEnd = new Date();

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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

    public int getLessonNumber() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        try {
            if (lessonStart.after(sdf.parse("07:50")) && lessonEnd.before(sdf.parse("08:40"))) {
                return 1;
            } else if (lessonStart.after(sdf.parse("08:40")) && lessonEnd.before(sdf.parse("09:35"))) {
                return 2;
            } else if (lessonStart.after(sdf.parse("09:30")) && lessonEnd.before(sdf.parse("10:25"))) {
                return 3;
            } else if (lessonStart.after(sdf.parse("10:25")) && lessonEnd.before(sdf.parse("11:15"))) {
                return 4;
            } else if (lessonStart.after(sdf.parse("11:30")) && lessonEnd.before(sdf.parse("12:20"))) {
                return 5;
            } else if (lessonStart.after(sdf.parse("12:20")) && lessonEnd.before(sdf.parse("13:10"))) {
                return 6;
            } else if (lessonStart.after(sdf.parse("14:10")) && lessonEnd.before(sdf.parse("15:00"))) {
                return 7;
            } else if (lessonStart.after(sdf.parse("15:00")) && lessonEnd.before(sdf.parse("15:50"))) {
                return 8;
            } else if (lessonStart.after(sdf.parse("15:50")) && lessonEnd.before(sdf.parse("16:40"))) {
                return 9;
            } else {
                return 0;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
