package org.hors.impl.resolver;

/**
 * Result of the {@link RequestPattern#matcher(String)} operation.
 * @author asmirnov
 *
 */
public interface RequestMatcher {
	
	boolean matches();
	
	/**
	 * @return the rest of path that doesn't match pattern.
	 */
	String getTail();
	
	public String getParameter(String name);
	
	public Iterable<String> getParameterNames();

}
