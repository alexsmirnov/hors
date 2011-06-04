package org.hors.tck.resolver;

import javax.inject.Inject;

import org.hors.resolver.AnyRequest;
import org.hors.resolver.RequestPath;
import org.hors.view.FacesView;
import org.hors.view.Views;

@RequestPath("/")
public class TopLevelResolver {
	
	private final SecondLevelResolver controller;
	private final Views viewsFactory;
	
	@Inject
	public TopLevelResolver(SecondLevelResolver controller, Views viewsFactory) {
		this.controller = controller;
		this.viewsFactory = viewsFactory;
	}

	@RequestPath("protected/")
	public SecondLevelResolver doProtected(){
		return controller;
	}
	
	@AnyRequest
	public FacesView protectedJsfPage() {
		return viewsFactory.facesView("/welcome.xhtml");
	}

}
