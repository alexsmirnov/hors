package org.hors.servlet;

/**
 * This class represent context for current request ( Servlet, Portlet or some embedded case like Html email message generator ).
 * It holds only the most important values from request ( parameters, headers, path, writers etc ).
 * 
 * @author asmirnov
 *
 */
public interface WebRequest {

	/**
	 * @return the current request path.
	 */
	String getPath();
}
