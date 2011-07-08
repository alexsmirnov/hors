package org.hors.impl.resolver;

public interface ResourceProducer extends ResourceDescription {

	Object get(VisitContext context);
	
}
