package org.hors.impl.resolver;

import java.util.Iterator;
import java.util.Map;

import org.hors.impl.resolver.pattern.RequestMatcher;
import org.hors.impl.resolver.pattern.RequestPattern;

public abstract class ResourceDescription {

	public abstract Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters);
	

}
