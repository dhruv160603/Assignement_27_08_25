package com.example.demo;
import java.util.*;

public class Platform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Course> courses = new HashMap<>();

        while(true){
            System.out.println();
            System.out.println("Enter 0 to Exit");
            System.out.println("Enter 1 to create user");
            System.out.println("Enter 2 to create course");
            System.out.println("Enter 3 to enroll student in course");
            System.out.println("Enter 4 to create lesson");
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
                    System.out.println("New Instructor Successfully Registered");
                }
                else if (r.equals("Learner")) {
                    User u = new User(name, mail, pass, Role.Learner);
                    System.out.println("New Learner Successfully Registered");
                }
                else {
                    throw new IllegalArgumentException("Invalid role, Enter a Instructor or Learner ");
                }

            }
            else if (num == 2) {
                sc.nextLine();

                System.out.print("Enter the title ");
                String title = sc.nextLine();

                System.out.print("Enter the description ");
                String des = sc.nextLine();

                Course course = new Course(title, des);

                courses.put(title,course);

                System.out.println("The course " + title + " is successfully added");

            }
            else if (num == 3){
                System.out.println("The available courses are ");
                for (Map.Entry<String, Course> m : courses.entrySet()) {
                    System.out.println(m.getKey());
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
            else if (num ==4){
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
}
