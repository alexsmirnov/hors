package org.hors.impl.resolver.pattern;

import org.hors.impl.resolver.PathParameters;

/**
 * Result of the {@link RequestPattern#matcher(String)} operation.
 * @author asmirnov
 *
 */
public interface RequestMatcher extends PathParameters {
	
	boolean matches();
	
	/**
	 * @return the rest of path that doesn't match pattern.
	 */
	String getTail();

}
