package com.underarmour.model;

import java.util.Date;

/**
* Data Transfer Object representing chat
*/
public class Chat {
	private final int DEFAULT_TIMEOUT = 60000;

	private Date _creation = new Date();
	private long _id;
	private String _user;
	private String _text;
	private long _expiration;
	private int _timeout;


	public Chat() { }

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
	public long getExpiration() {
		if (this._expiration == 0) {
			this._expiration = calculateExpiration(this._timeout);
		}
		return this._expiration;
	}
	public void setExpiration(long expiration) { this._expiration = expiration; }
	public void setTimeout(int timeout) { this._timeout = timeout; }
	public int getTimeout() { return this._timeout; }
	public long getId() { return this._id; }
	public void setId(long id) { this._id = id; }

	private long calculateExpiration(int timeout) {
		long expiration;
		if (timeout > 0) {
			expiration = this._creation.getTime() + timeout;
		}
		else {
			expiration = this._creation.getTime() + DEFAULT_TIMEOUT;
		}

		return expiration;
	}
}