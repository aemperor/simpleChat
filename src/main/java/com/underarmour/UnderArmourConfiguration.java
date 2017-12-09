package com.underarmour;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class UnderArmourConfiguration extends Configuration {
	@Valid
	@NotNull
	private DataSourceFactory _database = new DataSourceFactory();

	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() { return this._database; }

	@JsonProperty("database")
	public void setDataSourceFactory(DataSourceFactory dataSourceFactory) { this._database = dataSourceFactory; }
}
