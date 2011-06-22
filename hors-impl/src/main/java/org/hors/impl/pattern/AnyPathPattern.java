package org.hors.impl.pattern;

import org.hors.servlet.WebRequest;

public class AnyPathPattern implements RequestPattern {

	public static final AnyPathPattern INSTANCE = new AnyPathPattern();
	
	
	@Override
	public int compareTo(RequestPattern o) {
		// Any pattern has minimal priority.
		return o instanceof AnyPathPattern?0:-1;
	}

	@Override
	public RequestMatcher matcher(String path, WebRequest request) {
		return new RequestPathMatcher(path);
	}

}
