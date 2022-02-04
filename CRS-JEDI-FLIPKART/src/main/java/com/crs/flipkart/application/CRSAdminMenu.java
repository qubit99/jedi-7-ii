package com.crs.flipkart.application;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.DummyDB;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.exception.InvalidStudentIdException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CRSAdminMenu {
    Scanner scanner = new Scanner(System.in);

    public void CRSAdminMenu(String adminId) {

    }

    public void adminChoice(String adminId) {
        AdminService adminService = new AdminService();


        int choice;
        do {
            System.out.println("=====WELCOME TO ADMIN MENU=====");
            System.out.println("You have the following choices: ");
            System.out.println("Enter 1 to view all courses");
            System.out.println("Enter 2 to view all students");
            System.out.println("Enter 3 to view all professors");
            System.out.println("Enter 4 to add course");
            System.out.println("Enter 5 to remove course");
            System.out.println("Enter 6 to add new professor");
            System.out.println("Enter 7 to approve a student registration");
            System.out.println("Enter 8 to remove student");
            System.out.println("Enter 9 to remove professor");
            System.out.println("Enter 10 to exit");
            choice = scanner.nextInt();
            if(choice==1) {
                System.out.println("Displaying All Courses: ");
                List<Course> courses = adminService.viewAllCourses();
                courses.forEach(course -> System.out.println(course.getCourseName() + "------------" + course.getInstructor()));
            }
            else if(choice==2) {
                System.out.println("Displaying All students: ");
                List<Student> students = adminService.viewAllStudents();
                students.forEach(student -> System.out.println(student.getUserId()+"--"+student.getPd().getName()+"--"+student.getRollNo()+"--"+student.getDepartment()));
            }
            else if(choice==3) {
                System.out.println("Displaying All professors: ");
                List<Professor>  professorList = adminService.viewAllProfessors();
                for(Professor professor: professorList){
                    System.out.println(professor.getUserId() + "--"+ professor.getPd().getName()+"--"+professor.getDepartment());
                }
            }
            else if(choice==4) {
                Course course = new Course();
                System.out.println("ADD COURSE INFO");
                System.out.println("Enter Course Id");
                course.setCourseId(scanner.next());
                System.out.println("Enter Course Name");
                scanner.nextLine();
                course.setCourseName(scanner.nextLine());
                if(adminService.addCourse(course)){
                    System.out.println("Course Added Successfully");
                }

            }
            else if(choice==5) {

            }
            else if(choice==6) {
                Professor professor = new Professor();
                PersonalDetails pd = new PersonalDetails();
                System.out.println("Enter the following details to add professor");
                System.out.println("Enter User Id");
                professor.setUserId(scanner.next());
                System.out.println("Enter password");
                professor.setPassword(scanner.next());
                System.out.println("Enter Department");
                professor.setDepartment(scanner.next());
                scanner.nextLine();
                System.out.println("Enter Name");
                pd.setName(scanner.nextLine());
                System.out.println("Enter PhoneNo.");
                pd.setPhoneNo(scanner.nextLine());
                System.out.println("Enter Address");
                pd.setAddress(scanner.nextLine());
                professor.setPd(pd);
                try {
                    if(adminService.addProfessor(professor));
                        System.out.println("Professor Added");
                } catch (UserIdAlreadyInUseException|ProfessorNotAddedException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(choice==7) {
                System.out.println("Approve Student Registration: ");
                System.out.println("enter student id: ");
                String sid = scanner.next();
                try {
                    adminService.approveStudentRegistration(sid);
                    System.out.println("Successfully verified student profile");
                }catch(InvalidStudentIdException ex) {
                    System.out.println("Invalid student id " + sid + ". Returning to menu");
                }
            }

            else if(choice==8) {
                break;
            }
            else if(choice==9) {

            }
            else if(choice==10) {
                System.out.println("Logged out");
                return;
            }
        } while(true);

        System.out.println("Returning to the main menu");
    }

}
