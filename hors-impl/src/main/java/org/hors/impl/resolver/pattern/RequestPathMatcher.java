package org.hors.impl.resolver.pattern;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class RequestPathMatcher implements RequestMatcher {

	private final boolean matches;
	private final String tail;
	private final ImmutableMap<String, String> params;

	
	RequestPathMatcher(boolean b) {
		this.matches = b;
		this.tail = "";
		this.params = ImmutableMap.of();
	}

	RequestPathMatcher(String tail) {
		this.matches = true;
		this.tail = tail;
		this.params = ImmutableMap.of();
	}

	RequestPathMatcher(String tail, Map<String, String> namedGroups) {
		this.matches = true;
		this.tail = tail;
		this.params = ImmutableMap.copyOf(namedGroups);
	}

	@Override
	public String getParameter(String name) {
		return params.get(name);
	}

	@Override
	public boolean hasParameter(String name) {
		return params.containsKey(name);
	}

	@Override
	public Iterable<String> getParameterNames() {
		return params.keySet();
	}

	@Override
	public boolean matches() {
		return matches;
	}

	@Override
	public String getTail() {
		return tail;
	}

}
