package org.hors.view;

/**
 * Implementation of this interface converts viewId ( request path )
 * to View instance and vice versa.
 * @author asmirnov
 *
 */
public interface ViewResolver <T> {
	
	/**
	 * @param viewId logical viewId.
	 * @return instance of hors View for given id.
	 */
	T find(String path);
	
	/**
	 * @param view target {@link View} 
	 * @return request path for that view.
	 */
	String getRequestPath(T view);

}
