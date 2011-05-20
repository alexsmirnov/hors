package org.hors.tck.view;

import java.util.Date;

import javax.inject.Inject;

import org.hors.component.Component;
import org.hors.component.Input;
import org.hors.model.Binding;
import org.hors.rest.RestService;

@Component
public class Calendar implements RestService {

	@Inject
	private Binding<Date> date;
	
	
	private RestService service;


	public void setDate(Date date) {
		this.date.set(date);
	}


	@Input
	public Date getDate() {
		return date.get();
	}


	/**
	 * @return the service
	 */
	public RestService getService() {
		return service;
	}


	
	// Delegate methods for Input/service ?
}
