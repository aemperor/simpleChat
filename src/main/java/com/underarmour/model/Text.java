package com.underarmour.model;

/** 
* Data Transfer Object representing text
*/
public class Text {
	private long _id;
	private String _text;

	public Text() {}

	public Text(long id, String text) {
		this._id = id;
		this._text = text;
	}

	public String getText() { return this._text; }
	public void setText(String text) { this._text = text; }
	public long getId() { return this._id; }
	public void setId(long id) { this._id = id; }
}