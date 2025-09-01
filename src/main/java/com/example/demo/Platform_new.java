package com.example.demo;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Platform_new {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Course> courses = new HashMap<>();
        HashMap<String, User> users = new HashMap<>();

        while(true){
            System.out.println();
            System.out.println("Enter 0 to Exit");
            System.out.println("Enter 1 to create user");
            System.out.println("Enter 2 to Login (Existing User)");

            System.out.println();

            int num = sc.nextInt();

            System.out.println();

            if (num==0){
                System.out.println("Finish");
            }
            else if(num == 1){
                System.out.print("Enter the name of user ");
                String name = sc.next();
                System.out.print("Enter your mail id ");
                String mail = sc.next();
                System.out.print("Enter your password ");
                String pass = sc.next();
                System.out.print("Enter the role (Instructor / Learner) ");
                String r = sc.next();
                if (r.equals("Instructor")){
                    User u = new User(name, mail, pass, Role.Instructor);
                    users.put(mail, u);
                    System.out.println("New Instructor Successfully Registered");
                }
                else if (r.equals("Learner")) {
                    User u = new User(name, mail, pass, Role.Learner);
                    users.put(mail, u);
                    System.out.println("New Learner Successfully Registered");
                }
                else {
                    throw new IllegalArgumentException("Invalid role, Enter a Instructor or Learner ");
                }

            }
            else if (num == 2) {
                System.out.println("Login:");
                System.out.print("Enter your mail id ");
                String m = sc.next();

                System.out.print("Enter your password ");
                String p = sc.next();


                if (users.containsKey(m)){
                    User u = users.get(m);
                    if (p.equals(u.getPassword())){
                        System.out.println("Login Successfull");
                        if (u.getRole()==Role.Instructor){
                            while(true){
                                System.out.println();
                                System.out.println("Enter 0 to Log-Out");
                                System.out.println("Enter 1 to create course");
                                System.out.println("Enter 2 to create lesson");
                                System.out.println();

                                num = sc.nextInt();

                                System.out.println();

                                if (num==0){
                                    System.out.println("Log-Out Successfull");
                                    break;
                                }
                                else if(num ==1){
                                    sc.nextLine();

                                    System.out.print("Enter the title ");
                                    String title = sc.nextLine();

                                    System.out.print("Enter the description ");
                                    String des = sc.nextLine();

                                    Course course = new Course(title, des);

                                    courses.put(title,course);

                                    System.out.println("The course " + title + " is successfully added");
                                }
                                else if (num == 2){
                                    sc.nextLine();
                                    System.out.print("Enter the title of lesson ");
                                    String l_title = sc.nextLine();

                                    System.out.print("Enter the lesson description ");
                                    String l_des = sc.nextLine();

                                    System.out.print("Enter the url of video ");
                                    String url = sc.next();
                                    sc.nextLine();

                                    Lesson l = new Lesson(l_title, l_des, url);

                                    if (courses.size()==0){
                                        System.out.println("There is no course, First create a course");
                                        continue;
                                    }
                                    System.out.print("Enter the course name to add Lesson in ");
                                    String t = sc.nextLine();

                                    Course c = courses.get(t);
                                    if (c != null){
                                        c.add_lesson(l);
                                    }
                                    else{
                                        System.out.print("Enter a valid course title ");
                                    }
                                }
                                else{
                                    System.out.println("Enter a valid operation");
                                }
                            }
                        }
                        else{
                            while(true){

                                System.out.println("Enter 0 to Log-Out");
                                System.out.println("Enter 1 to enroll in course available courses");
                                num = sc.nextInt();

                                System.out.println();

                                if (num== 0){
                                    System.out.println("Log-Out Successfull");
                                    break;
                                }
                                else if(num == 1){
                                    System.out.println("The available courses are ");
                                    for (Map.Entry<String, Course> map : courses.entrySet()) {
                                        System.out.println(map.getKey());
                                    }
                                    System.out.println();
                                    sc.nextLine();
                                    System.out.print("Enter the title of the course to enroll in ");
                                    String t = sc.nextLine();

                                    Course c = courses.get(t);
                                    if (c != null){
                                        System.out.print("Enter your id to enroll ");
                                        int id = sc.nextInt();

                                        c.enroll_students(id);

                                        System.out.println("Student with id " + id + " is successfully enrolled in " + c.title);

                                    }
                                    else{
                                        System.out.print("Enter a valid course title ");
                                    }
                                }
                                else{
                                    System.out.println("Enter a valid operation");
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("Incorrect password Try Again");
                    }
                }
                else{
                    System.out.println("No user with mail");
                    System.out.println("Create new user");
                }
            }
            else{
                System.out.println("Enter a valid operation");
            }

        }
    }
}
