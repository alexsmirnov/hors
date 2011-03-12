package org.hors.tck.view;

import javax.enterprise.event.Observes;
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
import org.hors.tck.model.Mybean;
import org.hors.view.HorsView;
import org.hors.view.Page;
import org.hors.view.View;

@Page(id="/index.html",template="/org/hors/tck/view/FormView.html")
public class FormView  {

	@Inject
	private HorsView<NextPage> nextPage;
	
	@Inject
	private Output title;
	
	@Inject
	private Form form;
	
	@Inject
	@Bind(name=Mybean.FORM_TEXT)
	@NotNull
	private Input text;
	
	@Inject
	@Service(CalendarService.class)
	@Bind(el="#{mybean.date}")
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
	
	/**
	 * Default action
	 * @param action
	 * @return
	 */
	public Object action(@Observes Action action){
		return this;
	}
	// TODO - provide examples with CDI delegate, inheritance etc.
}
