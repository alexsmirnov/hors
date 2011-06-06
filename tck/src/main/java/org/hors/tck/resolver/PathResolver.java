package org.hors.tck.resolver;

import org.hors.resolver.RequestPath;
import org.hors.tck.model.Bean;

@RequestPath("/foo")
public class PathResolver {

	@RequestPath("/bar")
	public Bean bar(){
		return new Bean("/foo/bar");
	}
}
