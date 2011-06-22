/**
 * 
 */
package org.hors.impl.resolver;

import javax.enterprise.inject.spi.Bean;

/**
 * @author asmirnov
 *
 */
public class ResourceBean extends BeanDescription {

	public ResourceBean(Bean<?> bean) {
		super(bean);
	}

	/* (non-Javadoc)
	 * @see org.hors.impl.resolver.ResourceDescription#apply(org.hors.impl.resolver.ResourceDescriptionVisitor)
	 */
	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitParameters parameters) {
		return visitor.visit(this, parameters);
	}

}
