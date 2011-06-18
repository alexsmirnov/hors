/**
 * 
 */
package org.hors.impl.resolver;

/**
 * @author asmirnov
 *
 */
public class ResourceBean extends BeanDescription {

	/* (non-Javadoc)
	 * @see org.hors.impl.resolver.ResourceDescription#apply(org.hors.impl.resolver.ResourceDescriptionVisitor)
	 */
	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters) {
		return visitor.visit(this, parameters);
	}

}
