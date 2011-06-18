package org.hors.impl.resolver;

/**
 * @author asmirnov
 *
 */
public class ControllerMethod extends ResourceDescription {

	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters) {
		return visitor.visit(this, parameters);
	}

}
