package com.example.appsenzen;

import java.io.Serializable;
import java.util.ArrayList;

public class SchoolClass implements Serializable {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> studentNames = new ArrayList<>();

    private final String className;
    //private int studentCount;

    public SchoolClass(String name){
        this.className = name;
    }

    public String getClassName() {
        return className;
    }

    public int getStudentCount() {
        return students.size();
    }

    public void addStudent(Student student){
        String name = student.getName();
        if(!students.contains(student) && !studentNames.contains(name)){
            students.add(student);
            studentNames.add(name);
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
        }
    }

    public void removeStudent(String name){
        if(studentNames.contains(name)){
            int index = studentNames.indexOf(name);
            students.remove(index);
            studentNames.remove(index);
        }
    }

    public Student getStudent(int index){
        return students.get(index);
    }

    public Student getStudent(String name){
        int index = studentNames.indexOf(name);
        return students.get(index);
    }

    public void clear(){
        students = new ArrayList<>();
        studentNames = new ArrayList<>();
    }

}


