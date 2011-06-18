package org.hors.impl.resolver;


public interface ResourceDescriptionVisitor {

	Object visit(ResourceBean bean, VisitParameters parameters);
	
	Object visit(ControllerMethod method, VisitParameters parameters);
	
}
