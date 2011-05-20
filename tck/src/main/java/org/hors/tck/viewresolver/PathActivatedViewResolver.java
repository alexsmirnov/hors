package org.hors.tck.viewresolver;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Producer;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.hors.view.Activate;
import org.hors.view.RequestPath;
import org.hors.view.View;
import org.hors.view.ViewResolver;

/**
 * This resolver activated for all requests to the "/mobile/ folder.
 * It delegates all calls to the default resolver.
 * If request matches target path, it also activates {@link Mobile}
 * stereotype as default for CDI.
 * @author asmirnov
 *
 */
@Activate(Mobile.class)
@RequestScoped
@RequestPath("/mobile/.*")
public class PathActivatedViewResolver {
	
	private final ViewResolver defaultResolver;

	@Inject
	public PathActivatedViewResolver(ViewResolver defaultResolver) {
		this.defaultResolver = defaultResolver;
	}

	public ViewResolver<?> index() {
		return defaultResolver;
	}


}
