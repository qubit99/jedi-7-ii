package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.dao.ProfessorDaoInterface;
import com.crs.flipkart.dao.ProfessorDaoOperation;
import com.crs.flipkart.exception.InvalidCourseIdException;
import com.crs.flipkart.exception.InvalidGradeException;
import com.crs.flipkart.exception.ProfessorNotFoundException;
import com.crs.flipkart.exception.UserNotFoundException;
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
     * @param profId
     * @param courseId
     * @return
     * @throws InvalidCourseIdException
     */
    public List<PersonalDetails> viewEnrolledStudents(String profId, String courseId) throws InvalidCourseIdException {
        return professorDaoOperation.getEnrolledStudents(profId, courseId);
    }

    /**
     *
     * @param studentid
     * @param courseId
     * @param grade
     * @throws InvalidGradeException
     */
    public void giveGrades(String studentid, String courseId, String grade) throws InvalidGradeException {
        professorDaoOperation.giveGrades(studentid, courseId, grade);
    }
}
