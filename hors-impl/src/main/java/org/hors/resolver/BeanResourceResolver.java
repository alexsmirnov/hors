/**
 * 
 */
package org.hors.resolver;

import java.util.Map;

/**
 * @author asmirnov
 *
 */
public class BeanResourceResolver implements ResourceResolver {

	private Map<RequestPattern, ControllerBeanDescription> controllerBeans;
	
	/* (non-Javadoc)
	 * @see org.hors.resolver.ResourceResolver#resolve(java.lang.String)
	 */
	@Override
	public Object resolve(String path) {
		// find bean that matches request.
		// find bean method that matches rest of the path.
		//   if no appropriate method found, try another bean ?
		// get controller bean instance and call controller method.
		// if no bean that matches request found, throw exception ( or return default 404 object ? )
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hors.resolver.ResourceResolver#getPath(java.lang.Object)
	 */
	@Override
	public String getPath(Object resource) {
		// TODO Auto-generated method stub
		return null;
	}

}
