package org.hors.impl.resolver;


public interface ResourceDescriptionVisitor {

	Object visit(ResourceBean bean, VisitParameters parameters);
	
	
}
