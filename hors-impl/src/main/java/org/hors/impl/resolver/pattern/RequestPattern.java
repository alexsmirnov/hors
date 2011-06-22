package org.hors.impl.resolver.pattern;

import java.io.Serializable;

import org.hors.servlet.WebRequest;

public interface RequestPattern extends Serializable, Comparable<RequestPattern> {

	RequestMatcher matcher(String path, WebRequest request);

}