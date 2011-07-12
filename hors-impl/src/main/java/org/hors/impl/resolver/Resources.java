/**
 * 
 */
package org.hors.impl.resolver;

import java.util.Iterator;
import java.util.Map;

import org.hors.impl.resolver.pattern.RequestMatcher;
import org.hors.impl.resolver.pattern.RequestPattern;

import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Maps;

/**
 * This class describes collection of resources with patterns
 * @author asmirnov
 *
 */
public class Resources implements ResourceDescription {
	
	private final ImmutableSortedMap<RequestPattern, ResourceDescription> resources;
	
	public Resources(Map<RequestPattern, ResourceDescription> resources) {
		this.resources = ImmutableSortedMap.copyOf(resources);
	}
	
	@Override
	public Object resolve(VisitContext visitContext) {
		Object result = applyToMap(resources, visitContext);
		return result;
	}
	
	/**
	 * Apply resource visitor to resources map. This method calls all resources in the Map where keys match
	 * current request, and return first not null value. 
	 * @param map pattern -&gt; resource Map
	 * @param visitor to apply
	 * @param visitContext current visit parameters.
	 * @return resource object for matching request, or null if none matched. 
	 */
	protected Object applyToMap(Map<RequestPattern,? extends ResourceDescription> map, VisitContext visitContext){
		Iterator<RequestPattern> iterator = map.keySet().iterator();
		Object result = null;
		while(iterator.hasNext() && null == result) {
			RequestPattern pattern = iterator.next();
			RequestMatcher matcher = pattern.matcher(visitContext.getPath(), visitContext.getRequest());
			if(matcher.matches()){				
				result = map.get(pattern).resolve(visitContext.nextLevelParameters(matcher));
			}
		}
		return result;
	}

	public static Builder builder(){
		return new Builder();
	}
	
	public static final class Builder {
		
		private Map<RequestPattern, ResourceDescription> map = Maps.newLinkedHashMap();
		private Builder() {
			// use static builder() method instead
		}
		
		public Builder put(RequestPattern pattern,ResourceDescription description){
			map.put(pattern, description);
			return this;
		}
		
		public Resources build(){
			return new Resources(map);
		}
	}
}
