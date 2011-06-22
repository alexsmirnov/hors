package org.hors.impl.resolver;

import javax.enterprise.inject.spi.Bean;

public abstract class BeanDescription extends ResourceDescription {

	private final Bean<?> bean;

	public BeanDescription(Bean<?> bean) {
		this.bean = bean;
	}


	public Bean<?> getBean() {
		return bean;
	}

}