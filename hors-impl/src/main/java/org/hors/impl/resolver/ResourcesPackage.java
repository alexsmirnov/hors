package org.hors.impl.resolver;

import java.util.Map;

import org.hors.impl.resolver.pattern.RequestPattern;

import com.google.common.collect.ImmutableSortedMap;

public class ResourcesPackage extends ResourceDescription {


	private final ImmutableSortedMap<RequestPattern, BeanDescription> beans;

	public ResourcesPackage(Map<RequestPattern, BeanDescription> map) {
		this.beans = ImmutableSortedMap.copyOf(map);
	}

	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters) {
		return applyToMap(beans, visitor, parameters);
	}

}
