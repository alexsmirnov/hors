package org.hors.resolver;

import org.hors.view.View;

/**
 * Implementation of this interface converts viewId ( request path )
 * to View instance and vice versa.
 * @author asmirnov
 *
 */
public interface ResourceResolver <T> {
	
	/**
	 * @param viewId logical viewId.
	 * @return instance of hors View for given id.
	 */
	T resolve(String path);
	
	/**
	 * @param view target {@link View} 
	 * @return request path for that view.
	 */
	String getPath(T view);

}
