package com.underarmour.db;

import org.postgresql.util.PSQLException;
import org.skife.jdbi.v2.exceptions.UnableToExecuteStatementException;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.Date;

/**
 * Chat Data Access Object
 */
public interface ChatDAO {

	@SqlUpdate("CREATE TABLE chat (id INTEGER PRIMARY KEY, username VARCHAR, text VARCHAR, expiration BIGINT)")
	public void createTable() throws UnableToExecuteStatementException;

	@SqlUpdate("INSERT INTO chat(id, username, text, expiration) VALUES (:id, :username, :text, :expiration)")
	void insertNamed(@Bind("id") long id, @Bind("username") String username, @Bind("text") String text, @Bind("expiration") long expiration);
}
