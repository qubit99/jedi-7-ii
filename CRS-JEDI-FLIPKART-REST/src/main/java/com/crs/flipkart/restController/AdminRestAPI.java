package com.crs.flipkart.restController;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.exception.InvalidStudentIdException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
public class AdminRestAPI {

    AdminService adminService = new AdminService();

    @GET
    @Path("/viewCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCoursesInCatalogue() {

        return adminService.viewAllCourses();

    }

    @GET
    @Path("/viewAllProfessors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> viewAllProfessors(){
        return adminService.viewAllProfessors();
    }

    /**
     *
     * @param professor
     * @return
     * @throws ValidationException
     */
    @POST
    @Path("/addProfessor")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfessor(@Valid Professor professor) throws ValidationException {

        try {

            adminService.addProfessor(professor);
            return Response.status(201).entity("Professor with professorId: " + professor.getUserId() + " added").build();

        } catch (ProfessorNotAddedException | UserIdAlreadyInUseException e) {

            return Response.status(409).entity(e.getMessage()).build();

        }

    }

    @POST
    @Path("/addCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(@Valid Course course) throws ValidationException{

        try {

            adminService.addCourse(course);
            return Response.status(201).entity("Course with courseCode: " + course.getCourseId() + " added to catalog").build();

        } catch (Exception e) {

            return Response.status(409).entity(e.getMessage()).build();

        }

    }


    @GET
    @Path("/viewPendingAdmissions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> viewPendingAdmissions(){
        return adminService.viewAllStudents(0);
    }

    @GET
    @Path("/viewAdmissions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> viewAdmissions(){
        return adminService.viewAllStudents(1);
    }

    @GET
    @Path("/approveStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveStudent(@QueryParam("rollNo") String rollNo){
        try {
            if(adminService.approveStudentRegistration(rollNo)){
                return Response.status(201).entity("Student with roll no" + rollNo + " approved").build();
            }
            else
                return Response.status(403).entity("Student with roll no" + rollNo + " not approved").build();
        } catch (InvalidStudentIdException e) {
            e.printStackTrace();
        }
        return null;
    }

}
