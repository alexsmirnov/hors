package org.hors.tck.view;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.hors.binding.Action;
import org.hors.component.Command;
import org.hors.component.Input;
import org.hors.component.Output;
import org.hors.view.Page;

@Page(id="/index.html",template="/org/hors/tck/view/FormView.html")
public class FormView  {

	@Inject
	private NextPage nextPage;
	
	@Output
	private String title;
	
	
	@NotNull
	@Input
	private String text;
	
	@Inject
	private Calendar calendar;
	
	
	
	public Object process(){
		return nextPage;
	}
	
	/**
	 * Default action
	 * @param action
	 * @return
	 */
	public Object action(@Observes Action action){
		return this;
	}

	/**
	 * @return the title
	 */
	@Command
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the calendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}

	/**
	 * @param calendar the calendar to set
	 */
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
}
