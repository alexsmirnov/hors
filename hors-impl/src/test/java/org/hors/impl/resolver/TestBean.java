package org.hors.impl.resolver;

import org.hors.resolver.RequestPath;

@RequestPath(TestBean.FOO_BAR)
public class TestBean {

	static final String FOO_BAR = "foo/bar";
	
	private String name;

	public TestBean() {
	}

	public TestBean(String name) {
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
