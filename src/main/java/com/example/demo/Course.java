package com.example.demo;

import java.util.ArrayList;

public class Course {
    String title;
    String description;
    ArrayList<Integer> students = new ArrayList<Integer>();
    ArrayList<Lesson> lessons = new ArrayList<>();

    Course(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    void enroll_students(int id){
        students.add(id);
    }
    void add_lesson(Lesson l){
        lessons.add(l);
    }


}
