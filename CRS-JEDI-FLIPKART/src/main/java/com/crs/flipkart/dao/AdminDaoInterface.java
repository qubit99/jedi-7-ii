package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;

import java.util.List;

public interface AdminDaoInterface {

    /**
     *
     * @return list of courses in a given catalog
     */
    public List<Course> viewAllCourses();

    /**
     *
     * @return list of all professors
     */
    public List<Professor> viewAllProfessors();
    public List<Student> viewAllStudents();

    /**
     *
     * @param professor
     * @return True if professor added successfully
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public boolean addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;


    Boolean addCourse(Course course);
}
