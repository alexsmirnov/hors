package org.hors.impl.resolver;


public interface ResourceDescriptionVisitor {

	Object visit(ResourceProducer producer, VisitContext parameters);
		
}
