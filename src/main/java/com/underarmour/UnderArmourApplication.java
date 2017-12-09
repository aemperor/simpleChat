package com.underarmour;

import com.underarmour.resources.ChatResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UnderArmourApplication extends Application<UnderArmourConfiguration> {

    public static void main(final String[] args) throws Exception {
        new UnderArmourApplication().run(args);
    }

    @Override
    public String getName() {
        return "UnderArmour";
    }

    @Override
    public void initialize(final Bootstrap<UnderArmourConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final UnderArmourConfiguration configuration,
                    final Environment environment) {
        final ChatResource resource = new ChatResource();
        environment.jersey().register(resource);
    }

}
