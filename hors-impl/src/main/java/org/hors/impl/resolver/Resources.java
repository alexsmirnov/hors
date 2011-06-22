/**
 * 
 */
package org.hors.impl.resolver;

import java.util.Map;

import org.hors.impl.pattern.RequestPattern;

import com.google.common.collect.ImmutableSortedMap;

/**
 * @author asmirnov
 *
 */
public class Resources extends ResourceDescription {
	
	private final ImmutableSortedMap<RequestPattern, ResourcesPackage> packages;
	
	public Resources(Map<RequestPattern, ResourcesPackage> packages) {
		this.packages = ImmutableSortedMap.copyOf(packages);
	}
	
	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters) {
		Object result = applyToMap(packages, visitor,parameters);
		return result;
	}

}
