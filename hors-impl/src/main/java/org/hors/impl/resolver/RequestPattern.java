/**
 * 
 */
package org.hors.impl.resolver;

import java.io.Serializable;
import java.util.regex.Pattern;

import org.hors.servlet.WebRequest;

/**
 * This object stores request mathing pattern ( path, method, parameters,headers... ).
 * Patterns can be ordered from more specific to generic, so concrete descriptions processed
 * first.
 * @author asmirnov
 *
 */
public class RequestPattern implements Serializable, Comparable<RequestPattern> {

	private Pattern pathPattern;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1039236324380548880L;
	
	public RequestMatcher matcher(String path,WebRequest request){
		return null;		
	}
		

	@Override
	public int compareTo(RequestPattern o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
