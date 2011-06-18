/**
 * 
 */
package org.hors.impl.resolver;

import java.util.Map;

/**
 * @author asmirnov
 *
 */
public class Resources extends ResourceDescription {

	
	private Map<RequestPattern, ResourcesPackage> packages;

	private Map<RequestPattern, ControllerMethod> beans;
	
	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters) {
		Object result = applyToMap(packages, visitor,parameters);
		if(null == result){
			result = applyToMap(beans, visitor,parameters);
		}
		return result;
	}

}
