package com.crs.flipkart.restController;


import com.crs.flipkart.bean.*;
import com.crs.flipkart.business.StudentInterface;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.exception.*;
import com.crs.flipkart.utils.JsonUtils;
import javafx.util.Pair;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Path("/student")
public class StudentRestAPI {
    StudentService studentService = new StudentService();

    @GET
    @Path("/viewCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCoursesInCatalogue() {

        return studentService.viewAllCourses();

    }

    @POST
    @Path("/addCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(@Valid CourseReq courseReq) throws ValidationException {
        try {
            System.out.println(courseReq.toString());
            studentService.addCourse(courseReq.getRollNo(),courseReq.getcID());
            return Response.status(201).entity("Course Added with Course Id " + courseReq.getcID()).build();
        } catch (AddCourseUnsuccessfulException e) {
            e.printStackTrace();
        }
        return Response.status(403).entity("Course was not added").build();
    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid Student student) throws ValidationException {
        System.out.println(student.toString());
        try {
            studentService.registerStudent(student);
            return Response.status(201).entity("Registration Successful").build();
        } catch (StudentIdAlreadyInUseException e) {
            e.printStackTrace();
        } catch (RegistrationUnsuccessfulException e) {
            e.printStackTrace();
        } catch (UserIdAlreadyInUseException e) {
            e.printStackTrace();
        }
        return Response.status(403).entity("Registration Unsuccessful").build();

    }

    @DELETE
    @Path("/removeCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeCourse(@Valid CourseReq courseReq) throws ValidationException{
        try {
            studentService.removeCourse(courseReq.getRollNo(),courseReq.getcID());
            return Response.status(201).entity("Course deleted with Course Id " + courseReq.getcID()).build();
        } catch (CourseRemovalUnsuccessfulException e) {
            e.printStackTrace();
        }
        return Response.status(403).entity("Course was not deleted").build();
    }


    @GET
    @Path("/getEnrolledCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PairPOJO> getEnrolledCourses(@QueryParam("rollNo") String rollNo){
        return JsonUtils.convertListOfPairToJson(studentService.viewEnrolledCourses(rollNo));
    }

    @GET
    @Path("/getNotifications/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notification> getNotifications(@QueryParam("rollNo") String rollNo){
        return studentService.getNotifications(rollNo);
    }
}
