package org.hors.impl.resolver;


/**
 * Implementation of this interface creates resource object for given request.
 * @author asmirnov
 *
 */
public interface ResourceDescription {

	/**
	 * Apply visitor for resource object.
	 * @param visitor
	 * @param parameters
	 * @return
	 */
	Object resolve(VisitContext parameters);	

}
