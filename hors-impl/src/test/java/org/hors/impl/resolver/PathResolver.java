package org.hors.impl.resolver;

import org.hors.resolver.RequestPath;


@RequestPath("/foo")
public class PathResolver {

	@RequestPath("/bar")
	public Bean bar(){
		return new Bean("/foo/bar");
	}
}
