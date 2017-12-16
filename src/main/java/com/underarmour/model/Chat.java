package com.underarmour.model;

import java.util.Date;

/**
* Data Transfer Object representing chat
*/
public class Chat {
	private final int DEFAULT_TIMEOUT = 60000;

	private long _id;
	private String _user;
	private String _text;
	private long _expiration;
	private int _timeout = DEFAULT_TIMEOUT;


	public Chat() { this._expiration = calculateExpiration(this._timeout); }

	public Chat(String user, String text) {
		this._user = user;
		this._text = text;
		this._expiration = calculateExpiration(this._timeout);
	}

	public Chat(String user, String text, int timeout) {
		this._user = user;
		this._text = text;
		this._expiration = calculateExpiration(timeout);
	}

	public Chat(long id, String user, String text, long expiration) {
		this._id = id;
		this._user = user;
		this._text = text;
		this._expiration = expiration;
	}

	public String getUser() { return this._user; }
	public void setUser(String user) { this._user = user; }
	public String getText() { return this._text; }
	public void setText(String text) { this._text = text; }
	public long getExpiration() { return this._expiration; }
	public void setExpiration(long expiration) { this._expiration = expiration; }
	public long getId() { return this._id; }
	public void setId(long id) { this._id = id; }

	private long calculateExpiration(int timeout) {
		return (new Date()).getTime() + timeout;
	}
}