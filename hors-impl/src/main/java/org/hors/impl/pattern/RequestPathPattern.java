/**
 * 
 */
package org.hors.impl.pattern;

import java.util.Map;

import org.hors.servlet.WebRequest;

/**
 * This object stores request mathing pattern ( path, method, parameters,headers... ).
 * Patterns can be ordered from more specific to generic, so concrete descriptions processed
 * first.
 * @author asmirnov
 *
 */
public class RequestPathPattern implements RequestPattern {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1039236324380548880L;
	private final NamedPattern namedPattern;
	private final String pattern;
	
	public RequestPathPattern(String pattern) {
		this.pattern = pattern;
		namedPattern = NamedPattern.compile(pattern);
	}
	/* (non-Javadoc)
	 * @see org.hors.impl.resolver.RequestPattern#matcher(java.lang.String, org.hors.servlet.WebRequest)
	 */
	@Override
	public RequestMatcher matcher(String path,WebRequest request){
		NamedMatcher matcher = namedPattern.matcher(path);
		if(matcher.find() && 0 == matcher.start()){
			String tail = path.substring(matcher.end());
			Map<String, String> namedGroups = matcher.namedGroups();
			return new RequestPathMatcher(tail,namedGroups);
		} else {
			return new RequestPathMatcher(false);
		}
	}
		

	@Override
	public int compareTo(RequestPattern o) {
		if( o instanceof AnyPathPattern){
			return 1;
		} else if (o instanceof RequestPathPattern) {
			RequestPathPattern pathPattern = (RequestPathPattern) o;
			// TODO compare patterns by more/less concrete.
			return pattern.compareTo(pathPattern.pattern);
		} else {
			return -1;
		}
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestPathPattern other = (RequestPathPattern) obj;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		return true;
	}
}