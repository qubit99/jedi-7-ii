package com.crs.flipkart;
import com.crs.flipkart.restController.StudentRestAPI;
import com.crs.flipkart.restController.UserRestAPI;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import com.crs.flipkart.restController.AdminRestAPI;
public class App extends Application<Configuration>{

    private static Logger logger = Logger.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        logger.info("Registering REST resources");
        environment.jersey().register(new AdminRestAPI());
        environment.jersey().register(new UserRestAPI());
        environment.jersey().register(new StudentRestAPI());

    }
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        logger.info("hi");
        new App().run(args);
    }
}
