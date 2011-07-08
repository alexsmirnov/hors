package org.hors.impl.resolver.cdi;

import javax.enterprise.inject.spi.Bean;

import org.hors.impl.resolver.pattern.RequestPattern;

public class ControllerBean<T> {
	
	private final RequestPattern pattern;
	private final Bean<T> managedBean;

	public ControllerBean(RequestPattern pattern,Bean<T> managedBean) {
		this.pattern = pattern;
		this.managedBean = managedBean;
	}

	public RequestPattern getPattern() {
		return pattern;
	}

	public Bean<T> getManagedBean() {
		return managedBean;
	}

}
