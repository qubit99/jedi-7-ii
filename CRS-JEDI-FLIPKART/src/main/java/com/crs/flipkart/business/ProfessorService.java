package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.dao.ProfessorDaoInterface;
import com.crs.flipkart.dao.ProfessorDaoOperation;
import com.crs.flipkart.exception.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorService implements ProfessorInterface {
    public ProfessorService(){

    }

    private static Logger logger = Logger.getLogger(ProfessorService.class);

    ProfessorDaoInterface professorDaoOperation = new ProfessorDaoOperation();

    /**
     *
     * @param profId
     * @return
     * @throws ProfessorNotFoundException
     */
    public List<Course> viewTeachingCourses(String profId) throws ProfessorNotFoundException {
        return professorDaoOperation.getTeachingCourses(profId);
    }

    /**
     *
     * @param courseId
     * @return
     * @throws InvalidCourseIdException
     */
    public List<Pair<PersonalDetails,String>> viewEnrolledStudents(String courseId) throws InvalidCourseIdException {
        return professorDaoOperation.getEnrolledStudents(courseId);
    }

    /**
     *
     * @param studentid
     * @param courseId
     * @param grade
     * @throws InvalidGradeException
     */
    public Boolean giveGrades(String studentid,String profID, String courseId, String grade)  {
       return professorDaoOperation.giveGrades(studentid, profID, courseId, grade);
    }

    public Boolean selectTeachingCourses(String profId, String courseId) throws CourseUpdationFailureException {
        return professorDaoOperation.selectTeachingCourses(profId,courseId);
    }

    @Override
    public ArrayList<Course> viewAvailableCourses() {
        return professorDaoOperation.getAvailableCourses();
    }
}
