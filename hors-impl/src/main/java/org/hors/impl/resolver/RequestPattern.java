package org.hors.impl.resolver;

import org.hors.servlet.WebRequest;

public interface RequestPattern {

	RequestMatcher matcher(String path, WebRequest request);

}