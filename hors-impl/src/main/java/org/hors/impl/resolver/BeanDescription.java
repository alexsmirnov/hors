package org.hors.impl.resolver;

import javax.enterprise.inject.spi.Bean;

public abstract class BeanDescription extends ResourceDescription {

	private Bean<?> bean;

	public BeanDescription() {
		super();
	}

	public void setBean(Bean<?> bean) {
		this.bean = bean;
	}

	public Bean<?> getBean() {
		return bean;
	}

}