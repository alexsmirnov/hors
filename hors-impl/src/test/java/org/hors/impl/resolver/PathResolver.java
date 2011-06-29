package org.hors.impl.resolver;

import javax.enterprise.inject.Produces;

import org.hors.resolver.RequestPath;


@RequestPath("/baz")
public class PathResolver {
	
	@Produces
	private Bean baz = new Bean("/baz");

	@Produces
	@RequestPath("/bar")
	public Bean bar(){
		return new Bean("/baz/bar");
	}
}
