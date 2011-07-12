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
public class ResourceBean<X> implements ResourceDescription {

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
	public Object resolve(VisitContext parameters) {
		CreationalContext<X> creationalContext = manager.createCreationalContext(bean);
		return bean.create(creationalContext);
	}


}
