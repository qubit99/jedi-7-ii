package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.CourseRegistration;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.Map;

public interface StudentInterface {
    public Student registerStudent();
    public void viewGradeCard(Student student, Map<String, GradeCard> gradeCardList);
    public ArrayList<String> registerForCourses();
    public void viewCourses(ArrayList<Course> courses);
    public void addCourse(Student student, Map<String, CourseRegistration> studentCourses);
    public void removeCourse(Student student, Map<String, CourseRegistration> studentCourses);
    }
