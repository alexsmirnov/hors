package org.hors.resolver;

/**
 * Result of the {@link RequestPattern#matcher(String)} operation.
 * @author asmirnov
 *
 */
public interface RequestMatcher {
	
	boolean matches();
	
	String getPathFragment();
	
	public String getParameter(String name);
	
	public Iterable<String> getParameterNames();

}
