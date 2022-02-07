package com.crs.flipkart.restController;

import com.crs.flipkart.bean.*;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.exception.InvalidCourseIdException;
import com.crs.flipkart.exception.ProfessorNotFoundException;
import com.crs.flipkart.utils.JsonUtils;
import javafx.util.Pair;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/professor")
public class ProfessorRestAPI {

    ProfessorService professorService = new ProfessorService();

    @GET
    @Path("/viewCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCoursesInCatalogue(@QueryParam("profId") String profId){

        try {
            return professorService.viewTeachingCourses(profId);
        } catch (ProfessorNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/viewEnrolledStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PairPOJO> viewEnrolledStudents(@QueryParam("courseId")String courseId){
        System.out.println(courseId);
        try {
            return JsonUtils.convertListOfPairToJson(professorService.viewEnrolledStudents(courseId));
        } catch (InvalidCourseIdException e) {
            e.printStackTrace();
        }
        return null;
    }

    @POST
    @Path("/giveGrades")
    @Produces(MediaType.APPLICATION_JSON)
    public Response giveGrades(@Valid Grade grade){
        System.out.println(grade.toString());
        if(professorService.giveGrades(grade.getRollNo(),grade.getProfId(),grade.getCourseId(),grade.getGrade()))
            return Response.status(201).entity("Grade given").build();
        return Response.status(403).entity("Operation Failed").build();

    }
}
