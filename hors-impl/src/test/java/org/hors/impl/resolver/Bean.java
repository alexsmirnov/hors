package org.hors.impl.resolver;

import org.hors.resolver.RequestPath;

@RequestPath(Bean.FOO_BAR)
public class Bean {

	static final String FOO_BAR = "/foo/bar";
	
	private String name;

	public Bean() {
	}

	public Bean(String name) {
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
