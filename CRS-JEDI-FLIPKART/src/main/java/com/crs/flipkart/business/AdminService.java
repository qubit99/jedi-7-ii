package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminService implements AdminInterface{

    @Override
    public String addProfessor(Professor professor) {
        DummyDB.professorList.put("P#", professor);
        return professor.getPd().getName()+"added";
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
    public String approveStudentRegistration(Student student) {
        return null;
    }

    @Override
    public ArrayList<Student> viewAllStudents() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        for(Student student: DummyDB.studentList.values()){
            studentList.add(student);
        }
        return studentList;

    }

    @Override
    public ArrayList<Professor> viewAllProfessors() {
        return null;
    }

    @Override
    public ArrayList<Course> viewAllCourses() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        for(Course course: DummyDB.courseList.values()){
            courseList.add(course);
        }
        return courseList;
    }
}
