package com.underarmour.db;

import org.postgresql.util.PSQLException;
import org.skife.jdbi.v2.exceptions.UnableToExecuteStatementException;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Chat Data Access Object
 */
public interface ChatDAO {

	@SqlUpdate("CREATE TABLE chat (id INTEGER PRIMARY KEY, username VARCHAR, text VARCHAR, timeout INTEGER)")
	public void createTable() throws UnableToExecuteStatementException;

	@SqlUpdate("INSERT INTO chat(id, username, text, timeout) VALUES (:id, :username, :text, :timeout)")
	void insertNamed(@Bind("id") long id, @Bind("username") String username, @Bind("text") String text, @Bind("timeout") long timeout);
}
