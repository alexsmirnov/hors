/**
 * 
 */
package org.hors.impl.resolver;

import java.util.Map;


/**
 * This class describes controller CDI bean 
 * @author asmirnov
 *
 */
public class ControllerBean extends BeanDescription  {
	
	
	/**
	 * The map stores bean methods annotated as controller methods and their patterns.
	 */
	private Map<RequestPattern, ControllerMethod> controllerMethods;
	
	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters) {
		return  applyToMap(controllerMethods, visitor,parameters.forBean(getBean()));
	}

}
