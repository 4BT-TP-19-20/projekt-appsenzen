package com.example.appsenzen;

import java.io.Serializable;
import java.util.ArrayList;

public class SchoolClass implements Serializable {

    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<String> studentNames = new ArrayList<>();

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
        String name = student.getName();
        if(!students.contains(student) && !studentNames.contains(name)){
            students.add(student);
            studentNames.add(name);
            ++studentCount;
        }
    }

    public void addStudent(String name){
        Student student = new Student(name, this);
        addStudent(student);
    }

    public void removeStudent(Student student){
        if(students.contains(student)){
            String name = student.getName();
            students.remove(student);
            studentNames.remove(name);
            --studentCount;
        }
    }

    public void removeStudent(String name){
        if(studentNames.contains(name)){
            int index = studentNames.indexOf(name);
            students.remove(index);
            studentNames.remove(index);
            --studentCount;
        }
    }

    public Student getStudent(int index){
        return students.get(index);
    }

    public Student getStudent(String name){
        int index = studentNames.indexOf(name);
        return students.get(index);
    }

}


