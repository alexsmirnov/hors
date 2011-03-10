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
 * It delegates all calls to the default resolver, injected by CDI,
 * with appropriate path transformations.
 * If request matches target path, it also activates {@link Mobile}
 * stereotype as default for CDI.
 * @author asmirnov
 *
 */
@Activate(Mobile.class)
@RequestScoped
@Path("/mobile/{id}")
@RequestPath("/mobile/{id}")
public class PathActivatedViewResolver implements ViewResolver {
	
	private final ViewResolver defaultResolver;
	private final Provider<String> pathId;

	@Inject
	public PathActivatedViewResolver(ViewResolver defaultResolver, @PathParam("id") Provider<String> pathId) {
		this.defaultResolver = defaultResolver;
		this.pathId = pathId;
	}

	@Override
	public View find(String viewId) {
		return defaultResolver.find(pathId.get());
	}

	@Override
	public String getRequestPath(View view) {
		return "/mobile"+defaultResolver.getRequestPath(view);
	}

}
