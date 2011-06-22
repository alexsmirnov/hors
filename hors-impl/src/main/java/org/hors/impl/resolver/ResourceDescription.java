package org.hors.impl.resolver;

import java.util.Iterator;
import java.util.Map;

import org.hors.impl.pattern.RequestMatcher;
import org.hors.impl.pattern.RequestPattern;

public abstract class ResourceDescription {

	public abstract Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters);
	
	protected Object applyToMap(Map<RequestPattern,? extends ResourceDescription> map,ResourceDescriptionVisitor visitor, VisitParameters parameters){
		Iterator<RequestPattern> iterator = map.keySet().iterator();
		Object result = null;
		while(iterator.hasNext() && null == result) {
			RequestPattern pattern = iterator.next();
			RequestMatcher matcher = pattern.matcher(parameters.getPath(), parameters.getRequest());
			if(matcher.matches()){				
				result = map.get(pattern).apply(visitor, parameters.nextLevelParameters(matcher));
			}
		}
		return result;
	}
}
