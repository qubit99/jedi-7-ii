package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

import java.util.ArrayList;

public class AdminService implements AdminInterface{

    @Override
    public String addProfessor(Professor professor) {
        return null;
    }

    @Override
    public String removeProfessor(int professorId) {
        return null;
    }

    @Override
    public String updateProfessor(Professor professor) {
        return null;
    }

    @Override
    public String approveStudentRegistration(Student student) {
        return null;
    }

    @Override
    public ArrayList<Student> viewAllStudents() {
        return null;
    }

    @Override
    public ArrayList<Professor> viewAllProfessors() {
        return null;
    }

    @Override
    public ArrayList<Course> viewAllCourses() {
        return null;
    }
}
