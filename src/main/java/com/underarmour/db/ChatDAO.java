package com.underarmour.db;

import com.underarmour.model.Chat;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Optional;

/**
 * Chat Data Access Object
 */
public class ChatDAO extends AbstractDAO {
	public ChatDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Optional<Chat> findById(long id) {
		return Optional.ofNullable((Chat)get(id));
	}

	public Chat create(Chat chat) {
		return (Chat)persist(chat);
	}
}
