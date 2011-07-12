package org.hors.impl.resolver.pattern;

public class RequestPatterns {
	
	private RequestPatterns() {
		// static methods only
	}

	public static RequestPattern pathPattern(String path){
		return new RequestPathPattern(path);
	}

	public static RequestPattern anyRequest(){
		return AnyPathPattern.INSTANCE;
	}

}
