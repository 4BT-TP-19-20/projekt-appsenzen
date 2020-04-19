package com.example.appsenzen;

import android.widget.Button;

import java.util.ArrayList;

public class SchoolClass {

    public String className;
    public ArrayList<Student> schoolClass = new ArrayList<Student>();
    public int studentCount;

    SchoolClass(String name){
        this.studentCount = 0;
        this.className = name;
    }

    public void addStudent(Student student){
        schoolClass.add(student);
        studentCount++;
    }


}


