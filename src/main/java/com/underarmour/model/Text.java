package com.underarmour.model;

/** 
* Data Transfer Object representing text
*/
public class Text {
	private String _text;
	private String _description;

	public Text() {}

	public Text(String text, String description) {
		this._text = text;
		this._description = description;
	}

	public String getText() { return this._text; }

	public void setText(String text) { this._text = text; }

	public String getDescription() { return this._description; }

	public void setDescription(String description) { this._description = description; }
}