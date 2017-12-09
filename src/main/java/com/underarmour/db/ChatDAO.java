package com.underarmour.db;

import com.underarmour.model.Chat;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.Optional;

/**
 * Chat Data Access Object
 */
public interface ChatDAO {

	@SqlUpdate("CREATE TABLE chat (id INTEGER PRIMARY KEY, username VARCHAR, text VARCHAR, timeout INTEGER)")
	public void createTable();

	@SqlUpdate("INSERT INTO chat(id, username, text, timeout) VALUES (:id, :username, :text, :timeout)")
	void insertNamed(@Bind("id") int id, @Bind("username") String username, @Bind("text") String text, @Bind("timeout") long timeout);
}
