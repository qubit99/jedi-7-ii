package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

import java.util.ArrayList;

public interface AdminInterface {

    /**
     *
     * @param professor
     * @return
     */
    public String addProfessor(Professor professor);

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


    public ArrayList<Student> viewAllStudents();

    public ArrayList<Professor> viewAllProfessors();

    public ArrayList<Course> viewAllCourses();
}
