package com.underarmour;

import com.underarmour.db.ChatDAO;
import com.underarmour.model.Chat;
import com.underarmour.resources.ChatResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UnderArmourApplication extends Application<UnderArmourConfiguration> {

    public static void main(final String[] args) throws Exception {
        new UnderArmourApplication().run(args);
    }

    private final HibernateBundle<UnderArmourConfiguration> hibernateBundle =
            new HibernateBundle<UnderArmourConfiguration>(Chat.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(UnderArmourConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

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
        final ChatDAO chatDAO = new ChatDAO(hibernateBundle.getSessionFactory());

        final ChatResource resource = new ChatResource(chatDAO);
        environment.jersey().register(resource);
    }

}
