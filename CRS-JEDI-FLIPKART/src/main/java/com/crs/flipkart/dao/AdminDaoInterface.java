package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
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
     * @param catalogId
     * @return list of all professors
     */
    public List<Professor> viewProfessors(int catalogId);

    /**
     *
     * @param professor
     * @return True if professor added successfully
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public boolean addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;


}
