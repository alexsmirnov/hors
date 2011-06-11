package org.hors.resolver;


/**
 * Implementation of this interface converts viewId ( request path )
 * to View instance and vice versa.
 * @author asmirnov
 *
 */
public interface ResourceResolver {
	
	/**
	 * @param path logical viewId.
	 * @return instance of hors View for given id.
	 */
	Object resolve(String path);
	
	/**
	 * @param resource target object. 
	 * @return request path for that view.
	 */
	String getPath(Object resource);

}
