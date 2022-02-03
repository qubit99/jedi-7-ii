package com.crs.flipkart.restController;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.business.AdminService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/admin")
public class AdminRestAPI {

    AdminService adminService = new AdminService();

    @GET
    @Path("/viewCoursesInCatalogue")
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
}
