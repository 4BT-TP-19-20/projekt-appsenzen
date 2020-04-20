package com.example.appsenzen;

import android.widget.Button;

import java.util.ArrayList;

public class SchoolClass {

    private final ArrayList<Student> schoolClass = new ArrayList<>();
    private String className;
    private int studentCount;

    public SchoolClass(String name){
        this.studentCount = 0;
        this.className = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public void addStudent(Student student){
        schoolClass.add(student);
        ++studentCount;
    }

    public void removeStudent(Student student){
        if (!schoolClass.isEmpty()){
            schoolClass.remove(student);
            --studentCount;
        }
    }


}


