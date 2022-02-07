package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.exception.InvalidStudentIdException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;
import org.apache.log4j.Logger;

import java.util.List;

public class AdminService implements AdminInterface{

    private static Logger logger = Logger.getLogger(AdminService.class);

    AdminDaoInterface adminDaoOperation =new AdminDaoOperation();

    /**
     *
     * @param professor
     * @return true if prof added successfully
     * @throws UserIdAlreadyInUseException
     * @throws ProfessorNotAddedException
     */
    @Override
    public Boolean addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException {
        return  adminDaoOperation.addProfessor(professor);
    }


    /**
     *
     * @param professorId
     * @return true if prof removed successfully
     */
    @Override
    public Boolean removeProfessor(int professorId) {
        return adminDaoOperation.removeProfessor(professorId);
    }

    /**
     *
     * @param professor
     * @return
     */
    @Override
    public String updateProfessor(Professor professor) {
        return null;
    }

    /**
     *
     * @param rollNo
     * @return true if student approved successfully
     * @throws InvalidStudentIdException
     */
    @Override
    public boolean approveStudentRegistration(String rollNo) throws InvalidStudentIdException {
        return adminDaoOperation.approveStudentRegistration(rollNo);
    }

    /**
     *
     * @param flag for approved and unapproved students
     * @return List<Student>
     */
    @Override
    public List<Student> viewAllStudents(int flag) {
        return adminDaoOperation.viewAllStudents(flag);
    }

    @Override
    public List<Professor> viewAllProfessors() {
        return adminDaoOperation.viewAllProfessors();
    }

    @Override
    public List<Course> viewAllCourses() {
        return adminDaoOperation.viewAllCourses();
    }

    @Override
    public Boolean addCourse(Course course) {
        return adminDaoOperation.addCourse(course);
    }
}
