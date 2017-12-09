package com.underarmour;

import com.underarmour.db.ChatDAO;
import com.underarmour.resources.ChatResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

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
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final ChatDAO chatDAO = jdbi.onDemand(ChatDAO.class);

        final ChatResource resource = new ChatResource(chatDAO);
        environment.jersey().register(resource);
    }

}
