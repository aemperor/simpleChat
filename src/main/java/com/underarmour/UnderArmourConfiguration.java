package com.underarmour;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.DatabaseConfiguration;
import io.dropwizard.db.PooledDataSourceFactory;
import org.hibernate.validator.constraints.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class UnderArmourConfiguration extends Configuration {
	private static final Logger LOGGER = LoggerFactory.getLogger(UnderArmourConfiguration.class);

	@Valid
	@NotNull
	private PooledDataSourceFactory _database = new DataSourceFactory();

	/**
	 * This gets called with the values from the Dropwizard example.xmp, but we want to override it with the values
	 * from the Heroku DATABASE_URL environment variable.
	 */
	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() {
		LOGGER.info("Dropwizard dummy DB URL (will be overridden)=" + _database.getUrl());
		DatabaseConfiguration databaseConfiguration = UnderArmourDatabaseConfiguration.create(System.getenv("DATABASE_URL"));
		_database = databaseConfiguration.getDataSourceFactory(null);
		LOGGER.info("Heroku DB URL=" + _database.getUrl());
		return (DataSourceFactory)_database;
	}

	@JsonProperty("database")
	public void setDataSourceFactory(DataSourceFactory dataSourceFactory) { this._database = dataSourceFactory; }
}
