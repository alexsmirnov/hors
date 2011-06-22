/**
 * 
 */
package org.hors.impl.resolver;

import java.util.Map;

import javax.enterprise.inject.spi.Bean;

import org.hors.impl.pattern.RequestPattern;

import com.google.common.collect.ImmutableSortedMap;


/**
 * This class describes controller CDI bean 
 * @author asmirnov
 *
 */
public class ControllerBean extends BeanDescription  {
	
	
	/**
	 * The map stores bean methods annotated as controller methods and their patterns.
	 */
	private final ImmutableSortedMap<RequestPattern, ControllerMethod> controllerMethods;

	public ControllerBean(Bean<?> bean,Map<RequestPattern, ControllerMethod> methods) {
		super(bean);
		this.controllerMethods = ImmutableSortedMap.copyOf(methods);
	}

	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters) {
		return  applyToMap(controllerMethods, visitor,parameters.forBean(getBean()));
	}

}
