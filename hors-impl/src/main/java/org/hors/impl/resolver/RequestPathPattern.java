/**
 * 
 */
package org.hors.impl.resolver;

import java.io.Serializable;
import java.util.regex.Pattern;

import org.hors.impl.pattern.NamedPattern;
import org.hors.servlet.WebRequest;

/**
 * This object stores request mathing pattern ( path, method, parameters,headers... ).
 * Patterns can be ordered from more specific to generic, so concrete descriptions processed
 * first.
 * @author asmirnov
 *
 */
public class RequestPathPattern implements Serializable, Comparable<RequestPattern>, RequestPattern {

	private NamedPattern namedPattern;
	
	public RequestPathPattern(String pattern) {
		namedPattern = NamedPattern.compile(pattern);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1039236324380548880L;
	
	/* (non-Javadoc)
	 * @see org.hors.impl.resolver.RequestPattern#matcher(java.lang.String, org.hors.servlet.WebRequest)
	 */
	@Override
	public RequestMatcher matcher(String path,WebRequest request){
		return null;		
	}
		

	@Override
	public int compareTo(RequestPattern o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
