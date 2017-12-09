package com.underarmour.model;
/**
* Data Transfer Object representing chat
*/

public class Chat {
	private int _id;
	private String _user;
	private String _text;
	private int _timeout = 60000;


	public Chat() { }

	public Chat(String user, String text, int timeout) {
		this._user = user;
		this._text = text;
		this._timeout = timeout;
	}

	public String getUser() { return this._user; }
	public void setUser(String user) { this._user = user; }
	public String getText() { return this._text; }
	public void setText(String text) { this._text = text; }
	public int getTimeout() { return this._timeout; }
	public void setTimeout(int timeout) { this._timeout = timeout; }
	public int getId() { return this._id; }
	public void setId(int id) { this._id = id; }
}