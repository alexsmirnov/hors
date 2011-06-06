package org.hors.tck.resolver;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.hors.Application;
import org.hors.resolver.ResourceResolver;
import org.hors.tck.model.Bean;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class PathResolverTest {

	@Inject
	ResourceResolver<?> resolver;
	
	@Deployment
	public static JavaArchive deployment(){
		return ShrinkWrap.create(JavaArchive.class).addPackages(true, Application.class.getPackage());
	}
	
	@Test
	public void testResolvePath() throws Exception {
		Object resolved = resolver.resolve("/foo/bar");
		assertTrue(resolved instanceof Bean);
		assertEquals("/foo/bar", ((Bean)resolved).getName());
	}
}
