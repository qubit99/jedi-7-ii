package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;

import java.util.ArrayList;
import java.util.List;

public interface AdminInterface {

    /**
     *
     * @param professor
     * @return
     */
    public Boolean addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException;

    /**
     *
     * @param professorId
     * @return
     */
    public String removeProfessor(int professorId);

    /**
     *
     * @param professor
     * @return
     */
    public String updateProfessor(Professor professor);

    /**
     *
     * @param student
     * @return
     */
    public String approveStudentRegistration(Student student);


    public List<Student> viewAllStudents();

    public List<Professor> viewAllProfessors();

    public List<Course> viewAllCourses();

    public Boolean addCourse(Course course);
}
