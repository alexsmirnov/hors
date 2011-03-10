package org.hors.view;

/**
 * Implementation of this interface converts viewId ( request path )
 * to View instance and vice versa.
 * @author asmirnov
 *
 */
public interface ViewResolver {
	
	View find(String viewId);
	
	String getRequestPath(View view);

}
