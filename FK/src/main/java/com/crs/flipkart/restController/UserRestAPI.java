package com.crs.flipkart.restController;

import com.crs.flipkart.bean.Credential;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.UserService;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;
import com.crs.flipkart.exception.UserNotFoundException;
import com.crs.flipkart.exception.WrongPasswordException;
import sun.security.jgss.spi.GSSCredentialSpi;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserRestAPI {
    UserService userService = new UserService();

    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Valid Credential credential) throws ValidationException {

        try {

            if(userService.verifyCredentials(credential.getUserId(),credential.getPassword()));
                return Response.status(201).entity("Login Successful").build();

        } catch (UserNotFoundException|WrongPasswordException e) {
            return Response.status(409).entity(e.getMessage()).build();
        }
    }



}
