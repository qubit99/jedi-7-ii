package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.InvalidStudentIdException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.StudentNotAddedException;
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
     * @param student
     * @return
     * @throws UserIdAlreadyInUseException
     */
    public Boolean addStudent(Student student) throws UserIdAlreadyInUseException, StudentNotAddedException;

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
     * @param studentId
     * @return
     * @throws InvalidStudentIdException
     */
    public boolean approveStudentRegistration(String studentId) throws InvalidStudentIdException;

    /**
     *
     * @return
     */
    public List<Student> viewAllStudents();

    /**
     *
     * @return
     */
    public List<Professor> viewAllProfessors();

    /**
     *
     * @return
     */
    public List<Course> viewAllCourses();

    /**
     *
     * @param course
     * @return
     */
    public Boolean addCourse(Course course);
}
