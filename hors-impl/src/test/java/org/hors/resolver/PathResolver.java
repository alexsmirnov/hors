package org.hors.resolver;


@RequestPath("/foo")
public class PathResolver {

	@RequestPath("/bar")
	public Bean bar(){
		return new Bean("/foo/bar");
	}
}
