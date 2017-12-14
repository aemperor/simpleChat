package com.underarmour.db;

import com.underarmour.model.Text;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper for the Text class.
 */
public class TextMapper implements ResultSetMapper<Text> {
	@Override
	public Text map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
		return new Text(r.getLong("id"), r.getString("text"));
	}
}
