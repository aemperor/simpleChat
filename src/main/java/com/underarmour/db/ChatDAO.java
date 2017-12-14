package com.underarmour.db;

import com.underarmour.model.Chat;
import org.postgresql.util.PSQLException;
import org.skife.jdbi.v2.exceptions.UnableToExecuteStatementException;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Chat Data Access Object
 */
@RegisterMapper(ChatMapper.class)
public interface ChatDAO {

	@SqlUpdate("CREATE TABLE chat (id INTEGER PRIMARY KEY, username VARCHAR, text VARCHAR, expiration BIGINT)")
	public void createTable() throws UnableToExecuteStatementException;

	@SqlUpdate("INSERT INTO chat(id, username, text, expiration) VALUES (:id, :username, :text, :expiration)")
	public void insertNamed(@Bind("id") long id, @Bind("username") String username, @Bind("text") String text, @Bind("expiration") long expiration);

	@SqlQuery("SELECT * FROM chat where id = :id")
	public List<Chat> findAllChatsForId(@Bind("id") long id);

	@SqlQuery("SELECT * FROM chat where username= :username AND expiration >= :timeNow")
	public List<Chat> findAllUnexpiredChatsForUserName(@Bind("username") String username, @Bind("timeNow") long timeNow);
}
