package com.underarmour;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.DatabaseConfiguration;
import io.dropwizard.db.PooledDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Database configuration.
 */
public class UnderArmourDatabaseConfiguration implements DatabaseConfiguration {
	final static Logger LOGGER = LoggerFactory.getLogger(UnderArmourDatabaseConfiguration.class);
	private static DatabaseConfiguration dbConfig;


	public static DatabaseConfiguration create(String databaseUrl) {
		LOGGER.info("Creating database for URL " + databaseUrl);
		if (databaseUrl == null) {
			throw new IllegalArgumentException("The DATABASE_URL environment variable must be set before running the app " +
					"example: DATABASE_URL=\"postgres://username:password@host:5432/dbname\"");
		}

		DatabaseConfiguration dbConfig = null;

		try {
			URI dbUri = new URI(databaseUrl);
			final String user = dbUri.getUserInfo().split(":")[0];
			final String password = dbUri.getUserInfo().split(":")[1];
			final String url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath()
					+ "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			dbConfig = new DatabaseConfiguration() {
				PooledDataSourceFactory dataSourceFactory;
				@Override
				public DataSourceFactory getDataSourceFactory(Configuration configuration) {
					if (dataSourceFactory!= null) {
						return (DataSourceFactory)dataSourceFactory;
					}
					DataSourceFactory dsf = new DataSourceFactory();
					dsf.setUser(user);
					dsf.setPassword(password);
					dsf.setUrl(url);
					dsf.setDriverClass("org.postgresql.Driver");
					dataSourceFactory = dsf;
					return dsf;
				}
			};
		} catch (URISyntaxException e) {
			LOGGER.info(e.getMessage());
		}
		return dbConfig;
	}

	@Override
	public DataSourceFactory getDataSourceFactory(Configuration configuration) {
		LOGGER.info("Getting DataSourceFactory");
		if (dbConfig == null) {
			throw new IllegalStateException("You must first call DatabaseConfiguration.create(dbUrl)");
		}
		return (DataSourceFactory)dbConfig.getDataSourceFactory(null);
	}
}
