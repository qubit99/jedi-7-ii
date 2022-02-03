package com.crs.flipkart.restController;

import org.glassfish.jersey.server.ResourceConfig;



public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {

        register(AdminRestAPI.class);

    }

}