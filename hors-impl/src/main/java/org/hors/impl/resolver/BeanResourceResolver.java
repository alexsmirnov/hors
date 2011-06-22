/**
 * 
 */
package org.hors.impl.resolver;

import javax.inject.Inject;

import org.hors.resolver.ResourceResolver;
import org.hors.servlet.WebRequest;

/**
 * @author asmirnov
 *
 */
public class BeanResourceResolver implements ResourceResolver {

	/**
	 * Sorted map of controller descriptions. bean Patterns sorted from the most common to
	 * the broader
	 */
	private final Resources resources;
	
	private final ResourceDescriptionVisitor visitor;

	@Inject
	public BeanResourceResolver(Resources resources,ResourceDescriptionVisitor visitor) {
		this.resources = resources;
		this.visitor = visitor;
	}
	/* (non-Javadoc)
	 * @see org.hors.impl.resolver.ResourceResolver#resolve(java.lang.String)
	 */
	@Override
	public Object resolve(WebRequest request) {
		// find bean that matches request.
		// find bean method that matches rest of the path.
		//   if no appropriate method found, try another bean ?
		// get controller bean instance and call controller method.
		Object resource = resources.apply(visitor, new VisitParameters(request));
		// if no bean that matches request found, throw exception ( or return default 404 object ? )
		return resource;
	}

	/* (non-Javadoc)
	 * @see org.hors.impl.resolver.ResourceResolver#getPath(java.lang.Object)
	 */
	@Override
	public String getPath(Object resource) {
		// TODO Auto-generated method stub
		return null;
	}

}
