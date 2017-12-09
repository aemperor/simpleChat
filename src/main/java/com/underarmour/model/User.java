package com.underarmour.model;

/**
* Data Transfer Object representing the user.
*/

public class User {
	private String _username;
	private String _description;

	public User() {}

	public User(String username, String description) {
		this._username = username;
		this._description = description;
	}

	public String getUserName() { return this._username; }

	public void setUserName(String username) { this._username = username; }

	public String getDescription() { return this._description; }

	public void setDescription(String description) { this._description = description; }
}