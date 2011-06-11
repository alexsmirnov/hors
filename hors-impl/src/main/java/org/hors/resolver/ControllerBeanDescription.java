/**
 * 
 */
package org.hors.resolver;

import java.util.Map;

/**
 * This class describes controller CDI bean 
 * @author asmirnov
 *
 */
public class ControllerBeanDescription {
	
	
	/**
	 * The map stores bean methods annotated as controller methods and their patterns.
	 */
	private Map<RequestPattern, ControllerMethodDescription> controllerMethods;

}
