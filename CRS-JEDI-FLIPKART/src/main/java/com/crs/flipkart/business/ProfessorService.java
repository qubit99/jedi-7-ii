package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.exception.InvalidCourseIdException;
import com.crs.flipkart.exception.InvalidGradeException;
import com.crs.flipkart.exception.ProfessorNotFoundException;
import com.crs.flipkart.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorService {
    public ProfessorService(){

    }
    /**
     * Function to view courses a professor is teaching
     * @param profid
     * @return List of courses professor is teaching
     */
//    public List<Course> viewTeachingCourses(String profid) throws ProfessorNotFoundException {
//        HashMap<String, Course> courseList = DummyDB.courseList;
//        if(courseList.containsKey(profid)){
//            return courseList.get(profid);
//        }
//        else if(courseList.containsKey(profid)==false){
//            throw new ProfessorNotFoundException();
//        }
//        return null;
//    }

    /**
     * Function to view enrolled students for a course
     * @param profid, courseId
     * @return List of students enrolled in the course
     * @exception InvalidCourseIdException
     */
    public List<Student> viewEnrolledStudents(String profid, String courseId) throws InvalidCourseIdException {
        List<Student> temp = new ArrayList<Student>();
        return temp;
    }
    /**
     * Function to give grades to students
     * @param studentid, Course Id, HashTable of StudentId and Grade given
     * @exception InvalidGradeException
     */
    public void giveGrades(String studentid, String courseId, String grade) throws InvalidGradeException {

    }
}
