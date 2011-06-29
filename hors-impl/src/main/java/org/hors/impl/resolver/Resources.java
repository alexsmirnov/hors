/**
 * 
 */
package org.hors.impl.resolver;

import java.util.Iterator;
import java.util.Map;

import org.hors.impl.resolver.pattern.RequestMatcher;
import org.hors.impl.resolver.pattern.RequestPattern;

import com.google.common.collect.ImmutableSortedMap;

/**
 * @author asmirnov
 *
 */
public class Resources extends ResourceDescription {
	
	private final ImmutableSortedMap<RequestPattern, ResourceDescription> resources;
	
	public Resources(Map<RequestPattern, ResourceDescription> resources) {
		this.resources = ImmutableSortedMap.copyOf(resources);
	}
	
	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters) {
		Object result = applyToMap(resources, visitor,parameters);
		return result;
	}
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
