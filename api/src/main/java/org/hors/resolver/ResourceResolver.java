package org.hors.resolver;

import org.hors.servlet.WebRequest;


/**
 * Implementation of this interface converts viewId ( request path )
 * to View instance and vice versa.
 * @author asmirnov
 *
 */
public interface ResourceResolver {
	
	/**
	 * @param request the current request served by resolver.
	 * @return instance of hors View for given id.
	 */
	Object resolve(WebRequest request);
	
	/**
	 * @param resource target object. 
	 * @return request path for that view.
	 */
	String getPath(Object resource);

}
