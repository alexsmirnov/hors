package org.hors.impl.resolver;

public interface PathParameters {

	String getParameter(String name);

	boolean hasParameter(String name);

	Iterable<String> getParameterNames();

}