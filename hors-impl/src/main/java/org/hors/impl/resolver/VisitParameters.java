package org.hors.impl.resolver;

import javax.enterprise.inject.spi.Bean;

import org.hors.impl.pattern.RequestMatcher;
import org.hors.servlet.WebRequest;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/**
 * This class keeps current visit parameters to visit {@link ResourceDescription} objects tree
 * @author asmirnov
 *
 */
public final class VisitParameters implements PathParameters {

	private final String path;
	private final WebRequest request;
	private final ImmutableMap<String, String> pathParams;
	private final Bean<?> bean;

	public VisitParameters(WebRequest request) {		
		this(request.getPath(),request);
	}

	public VisitParameters(String path,WebRequest request) {
		this.path = path;
		this.request = request;
		this.pathParams = ImmutableMap.of();
		this.bean = null;
	}

	private VisitParameters(String tail, WebRequest request,
			ImmutableMap<String, String> build,Bean<?> bean) {
				this.path = tail;
				this.request = request;
				this.pathParams = build;
				this.bean = bean;
	}

	public VisitParameters nextLevelParameters(RequestMatcher matcher) {
		ImmutableMap<String, String> paramsMap = mergePathParameters(matcher);
		return new VisitParameters(matcher.getTail(), request,paramsMap,bean);
	}

	public VisitParameters forBean(Bean<?> bean) {
		return new VisitParameters(path, request,pathParams,bean);
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
