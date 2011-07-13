package org.hors.impl.resolver;

import org.hors.resolver.RequestPath;
import org.hors.resolver.Resource;

@RequestPath(TestBean.FOO_BAR)
@Resource
public class TestBean {

	public static final String FOO_BAR = "foo/bar";
	
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
