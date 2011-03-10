package org.hors.tck.view;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.hors.binding.Action;
import org.hors.binding.Bind;
import org.hors.binding.Service;
import org.hors.component.Command;
import org.hors.component.Form;
import org.hors.component.Input;
import org.hors.component.Output;
import org.hors.view.View;


public class FormView {

	@Inject
	private NextPage nextPage;
	
	@Inject
	private Output title;
	
	@Inject
	private Form form;
	
	@Inject
	@Bind("#{mybean.text")
	@NotNull
	private Input text;
	
	@Inject
	@Service(CalendarService.class)
	@Bind("#{mybean.date")
	private Calendar calendar;
	
	@Inject
	@Action("#{this.process}")
	private Command submit;
	
	/**
	 * This method takes command instance created by container, set its type to cancel and
	 * return instance for injection.
	 * @param command
	 * @return
	 */
	@Produces
	public Command getCancel(Command command){
		command.setCancel(true);
		return command;
	}
	
	public Object process(){
		return nextPage;
	}
	// TODO - provide examples with CDI delegate, inheritance etc.
}
