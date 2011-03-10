package org.hors.tck.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.hors.component.Component;
import org.hors.component.Input;
import org.hors.rest.RestService;

public class Calendar implements Input,RestService {

	@Inject
	private Input calendar;
	
	
	private RestService service;

	@PostConstruct 
	public void init(){
		// perform initialization here
	}
	
	// Delegate methods for Input/service ?
}
