package com.underarmour.db;

import com.underarmour.model.Chat;
import com.underarmour.model.ChatETO;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper from db for Chat class.
 */
public class ChatMapper implements ResultSetMapper<ChatETO> {
	@Override
	public ChatETO map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
		return new ChatETO(r.getLong("id"), r.getString("username"), r.getString("text"), r.getLong("expiration"));
	}
}
