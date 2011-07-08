package org.hors.impl.resolver;

import org.hors.impl.resolver.pattern.RequestMatcher;
import org.hors.servlet.WebRequest;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/**
 * This class keeps current visit parameters to visit {@link ResourceDescription} objects tree
 * @author asmirnov
 *
 */
public final class VisitContext implements PathParameters {

	private final String path;
	private final WebRequest request;
	private final ImmutableMap<String, String> pathParams;
	public VisitContext(WebRequest request) {		
		this(request.getPath(),request);
	}

	public VisitContext(String path,WebRequest request) {
		this.path = path;
		this.request = request;
		this.pathParams = ImmutableMap.of();
	}

	private VisitContext(String tail, WebRequest request,
			ImmutableMap<String, String> pathParams) {
				this.path = tail;
				this.request = request;
				this.pathParams = pathParams;
	}

	public VisitContext nextLevelParameters(RequestMatcher matcher) {
		ImmutableMap<String, String> paramsMap = mergePathParameters(matcher);
		return new VisitContext(matcher.getTail(), request,paramsMap);
	}


	protected final ImmutableMap<String, String> mergePathParameters(PathParameters params) {
		Builder<String,String> builder = ImmutableMap.builder();
		builder.putAll(pathParams);
		for (String param : params.getParameterNames()) {
			builder.put(param, params.getParameter(param));
		}
		ImmutableMap<String, String> paramsMap = builder.build();
		return paramsMap;
	}
	@Override
	public final String getParameter(String name) {
		return pathParams.get(name);
	}

	@Override
	public final boolean hasParameter(String name) {
		return pathParams.containsKey(name);
	}

	@Override
	public final Iterable<String> getParameterNames() {
		return pathParams.keySet();
	}

	/**
	 * Current level path.
	 * @return the path
	 */
	public final String getPath() {
		return path;
	}

	/**
	 * Web request to match resources
	 * @return the request
	 */
	public final WebRequest getRequest() {
		return request;
	}
}
