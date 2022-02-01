package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminService implements AdminInterface{

    private static Logger logger = Logger.getLogger(AdminService.class);

    AdminDaoInterface adminDaoOperation =new AdminDaoOperation();

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
    public List<Course> viewAllCourses() {
        return adminDaoOperation.viewAllCourses();
    }
}
