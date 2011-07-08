/**
 * 
 */
package org.hors.impl.resolver;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

/**
 * @author asmirnov
 *
 */
public class ResourceBean<X> implements ResourceProducer {

	private final Bean<X> bean;
	private final BeanManager manager;

	public ResourceBean(Bean<X> bean,BeanManager manager) {
		this.bean = bean;
		this.manager = manager;
	}

	/* (non-Javadoc)
	 * @see org.hors.impl.resolver.ResourceDescription#apply(org.hors.impl.resolver.ResourceDescriptionVisitor)
	 */
	@Override
	public Object apply(ResourceDescriptionVisitor visitor, VisitContext parameters) {
		return visitor.visit(this, parameters);
	}

	@Override
	public X get(VisitContext context) {
		CreationalContext<X> creationalContext = manager.createCreationalContext(bean);
		return bean.create(creationalContext);
	}

}
