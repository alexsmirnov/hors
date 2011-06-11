/**
 * 
 */
package org.hors.resolver;

import java.io.Serializable;

/**
 * This object stores request mathing pattern ( path, method, parameters,headers... ).
 * Patterns can be ordered from more specific to generic, so concrete descriptions processed
 * first.
 * @author asmirnov
 *
 */
public class RequestPattern implements Serializable, Comparable<RequestPattern> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1039236324380548880L;

	@Override
	public int compareTo(RequestPattern o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
