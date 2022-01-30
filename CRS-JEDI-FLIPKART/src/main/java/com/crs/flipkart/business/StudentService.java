package com.crs.flipkart.business;

import com.crs.flipkart.bean.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class StudentService implements StudentInterface{

    public Student registerStudent(){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Your Name");
        String name = sc.next();
        System.out.println("Enter Your phoneNo");
        String phoneNo = sc.next();
        System.out.println("Enter Your address");
        String address = sc.next();
        System.out.println("Enter Your userId");
        String userId = sc.next();
        System.out.println("Enter Your password");
        String password = sc.next();
        System.out.println("Enter Your rollNo");
        String rollNo = sc.next();
        System.out.println("Enter Your department");
        String department = sc.next();
        System.out.println("Enter Your year of joining");
        String yearOfJoining = sc.next();
        String role = "Student";

        PersonalDetails pd = new PersonalDetails(name,phoneNo,address);
        Student st = new Student(userId,password,role,pd,rollNo,department,yearOfJoining);
        return st;
    }

    public void viewGradeCard(Student student, Map<String,GradeCard> gradeCardList){
                System.out.println(gradeCardList.get(student.getUserId()));
    }

    public ArrayList<String> registerForCourses(){

        Scanner sc = new Scanner(System.in);
        ArrayList<String> courseIds = new ArrayList<>();
        String courseId;

        System.out.println("Enter your 4 primary choices");

        System.out.println("Enter courseId of your 1st choice");
        courseId = sc.next();
        courseIds.add(courseId);

        System.out.println("Enter courseId of your 2nd choice");
        courseId = sc.next();
        courseIds.add(courseId);

        System.out.println("Enter courseId of your 3rd choice");
        courseId = sc.next();
        courseIds.add(courseId);

        System.out.println("Enter courseId of your 4th choice");
        courseId = sc.next();
        courseIds.add(courseId);

        System.out.println("Enter your 2 secondary choices");

        System.out.println("Enter courseId of your 1st choice");
        courseId = sc.next();
        courseIds.add(courseId);

        System.out.println("Enter courseId of your 2nd choice");
        courseId = sc.next();
        courseIds.add(courseId);

        return courseIds;
    }

    public void removeCourse(Student student, Map<String, CourseRegistration> studentCourses){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the courseId you want to remove");
        String removeCourse;
        removeCourse = sc.next();

        String userId = student.getUserId();

        ArrayList<String> primaryCourses = studentCourses.get(userId).getPrimaryCourses();
        ArrayList<String> secondaryCourses = studentCourses.get(userId).getSecondaryCourses();
        String semester = studentCourses.get(userId).getSemester();
        primaryCourses.remove(removeCourse);
        secondaryCourses.remove(removeCourse);
        studentCourses.replace(userId,new CourseRegistration(primaryCourses,secondaryCourses,semester));
    }

    public void addCourse(Student student, Map<String, CourseRegistration> studentCourses){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the courseId you want to add");
        String addCourse;
        addCourse = sc.next();

        System.out.println("Press 1 : Primary Course");
        System.out.println("Press 2 : Secondary Course");
        int choice = sc.nextInt();

        String userId = student.getUserId();
        ArrayList<String> primaryCourses = studentCourses.get(userId).getPrimaryCourses();
        ArrayList<String> secondaryCourses = studentCourses.get(userId).getSecondaryCourses();
        String semester = studentCourses.get(userId).getSemester();


        if(choice == 1)
            primaryCourses.add(addCourse);
        else if(choice==2)
            secondaryCourses.remove(addCourse);

        studentCourses.replace(userId,new CourseRegistration(primaryCourses,secondaryCourses,semester));
    }
    
    public void viewCourses(ArrayList<Course> courses){
        System.out.println(courses);
    }
}
