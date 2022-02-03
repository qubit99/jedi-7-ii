package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.exception.InvalidStudentIdException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.StudentNotAddedException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminService implements AdminInterface{

    private static Logger logger = Logger.getLogger(AdminService.class);

    AdminDaoInterface adminDaoOperation =new AdminDaoOperation();

    @Override
    public Boolean addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException {
        return  adminDaoOperation.addProfessor(professor);
    }

    public Boolean addStudent(Student student) throws UserIdAlreadyInUseException, StudentNotAddedException {
        return  adminDaoOperation.addStudent(student);
    }

    @Override
    public String removeProfessor(int professorId) {
        if(DummyDB.professorList.containsKey(professorId)){
            DummyDB.professorList.remove(professorId);
            return "prof removed";
        }
        else{
            return "Prof with given prof id not found";
        }

    }

    @Override
    public String updateProfessor(Professor professor) {
        return null;
    }

    @Override
    public boolean approveStudentRegistration(String studentId) throws InvalidStudentIdException {
        return adminDaoOperation.approveStudentRegistration(studentId);
    }

    @Override
    public List<Student> viewAllStudents() {
        return adminDaoOperation.viewAllStudents();
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
