package com.example.appsenzen;

import android.widget.Button;

import java.util.ArrayList;

public class SchoolClass {

    private final ArrayList<Student> students = new ArrayList<>();
    private final String className;
    private int studentCount;

    public SchoolClass(String name){
        this.studentCount = 0;
        this.className = name;
    }

    public String getClassName() {
        return className;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void addStudent(Student student){
        if(!students.contains(student)){
            students.add(student);
            student.setSchoolClass(this);
            ++studentCount;
        }
    }

    public void removeStudent(Student student){
        if (!students.isEmpty() && students.contains(student)){
            students.remove(student);
            --studentCount;
        }
    }
}


