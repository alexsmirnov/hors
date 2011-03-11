package org.hors.tck.model;

import java.util.Date;

import javax.inject.Named;

import org.hors.model.Binded;


@Named
public class Mybean {

	public static final String FORM_TEXT="mybean.text";
	
	@Binded(FORM_TEXT)
	private String text;
	
	private Date date;

	private Iterable<String> pages;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setPages(Iterable<String> pages) {
		this.pages = pages;
	}

	public Iterable<String> getPages() {
		return pages;
	}
}
