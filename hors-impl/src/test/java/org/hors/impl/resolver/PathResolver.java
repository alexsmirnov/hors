package org.hors.impl.resolver;

import javax.enterprise.inject.Produces;

import org.hors.resolver.RequestPath;


@RequestPath("/baz")
public class PathResolver {
	
	@Produces
	private TestBean baz = new TestBean("/baz");

	@Produces
	@RequestPath("/bar")
	public TestBean bar(){
		return new TestBean("/baz/bar");
	}
}
