package org.hors.tck.resolver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;

import org.hors.resolver.ResourceResolver;
import org.hors.resolver.RequestPath;
import org.hors.servlet.RequestContext;
import org.hors.view.Activate;

/**
 * This resolver activated for all requests
 * that come to the "/mobile/ folder,
 * It delegates all calls to the default resolver with striped "mobile" prefix and activates {@code Mobile}
 * stereotype as default for CDI.
 * That controller used to switch between mobile and desktop presentations.
 * @author asmirnov
 *
 */
@RequestScoped
@RequestPath("/mobile/")
public class StereotypeActivatorResolver {
	
	private final ResourceResolver<?> defaultResolver;

	@Inject
	public StereotypeActivatorResolver(ResourceResolver<?> defaultResolver) {
		this.defaultResolver = defaultResolver;
	}

	@Mobile
	@RequestPath("{path}")
	public Object mobile(@PathParam("path") String path, RequestContext context){
		return defaultResolver.resolve(path);
	}

}
