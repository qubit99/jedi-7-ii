package com.crs.flipkart.business;

import com.crs.flipkart.bean.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DummyDB {

    public static Map<String, User>userList;
    public static Map<String, Student>studentList;
    public static Map<String , Professor>professorList;
    public static Map<String , Admin>adminList;
    public static HashMap<String , Course>courseList;


    public static void createDatabase(){

        userList = new HashMap<String, User>();

        userList.put("A1", new User("A1", "password", "admin"));
        userList.put("P2", new User("P2", "password", "professor"));
        userList.put("P3", new User("P3", "password", "professor"));
        userList.put("P4", new User("P4", "password", "professor"));
        userList.put("S5", new User("S5", "password", "student"));
        userList.put("S6", new User("S6", "password", "student"));
        userList.put("S7", new User("S7", "password", "student"));
        userList.put("S8", new User("S8", "password", "student"));

        studentList = new HashMap<String , Student>();
        studentList.put("S5", new Student("S5", "password", "student",
                new PersonalDetails("Pranay", "9051326639", "Allahabad" ),
                "22001", "CSE", "2018"));
        studentList.put("S6", new Student("S6", "password", "student",
                new PersonalDetails("Avantika", "9051323619", "UP" ),
                "22002", "CSE", "2018"));
        studentList.put("S7", new Student("S7", "password", "student",
                new PersonalDetails("Arya", "9921355139", "Lucknow" ),
                "22003", "CSE", "2018"));
        studentList.put("S8", new Student("S8", "password", "student",
                new PersonalDetails("Archit", "8910482988", "Kolkata" ),
                "22004", "IT", "2018"));

        professorList = new HashMap<String, Professor>();
        professorList.put("P3", new Professor("P3", "password","professor",
                new PersonalDetails("Amit Balyan", "9830058945", "Bangalore"),
                "CSE", "HOD"));
        professorList.put("P4", new Professor("P4", "password","professor",
                new PersonalDetails("HC Verma", "9830068945", "Kanpur"),
                "Physics", "Assistant Professor"));

        adminList = new HashMap<String, Admin>();
        adminList.put("A1", new Admin("A1", "password","admin",
                new PersonalDetails("Admin Sahab", "9830058905", "Bangalore")));

        courseList = new HashMap<String,Course>();
        ArrayList<Student> temp = new ArrayList<Student>();
        temp.add(studentList.get("S8"));
        temp.add(studentList.get("S7"));


    }
}


