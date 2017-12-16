package com.underarmour.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Chat Entity Transfer Object (ETO) for Response.
 */
public class ChatETO {
	private long _id;

	private Date _expirationDate;

	private String _text;

	private String _username;

	public ChatETO() { }

	public ChatETO(long id, String username, String text, long expiration) {
		this._id = id;
		this._username = username;
		this._text = text;
		this._expirationDate = new Date(expiration);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss a z")
	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}
}
