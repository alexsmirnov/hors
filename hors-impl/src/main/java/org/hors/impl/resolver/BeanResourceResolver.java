/**
 * 
 */
package org.hors.impl.resolver;

import java.util.Map;
import java.util.NavigableMap;

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
	private NavigableMap<RequestPattern, ControllerBeanDescription> controllerBeans;
	
	/* (non-Javadoc)
	 * @see org.hors.impl.resolver.ResourceResolver#resolve(java.lang.String)
	 */
	@Override
	public Object resolve(WebRequest request) {
		// find bean that matches request.
		// find bean method that matches rest of the path.
		//   if no appropriate method found, try another bean ?
		// get controller bean instance and call controller method.
		// if no bean that matches request found, throw exception ( or return default 404 object ? )
		return null;
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
