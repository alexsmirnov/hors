package org.hors.impl.resolver.cdi;

import static org.junit.Assert.*;

import javax.enterprise.inject.spi.Extension;
import javax.inject.Inject;

import org.hors.impl.resolver.BeanResourceResolver;
import org.hors.impl.resolver.PathResolver;
import org.hors.impl.resolver.ResourceDescription;
import org.hors.impl.resolver.TestBean;
import org.hors.resolver.ResourceResolver;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ExtensionTest {
	
	@Inject
	ResourceDescription resources;

	@Deployment
	public static JavaArchive deployment(){
		return ShrinkWrap.create(JavaArchive.class,"test.jar")
		   .addPackages(true, ResourceResolver.class.getPackage())
		   .addPackages(true, ControllerBeanExtension.class.getPackage())
		   .addClasses(TestBean.class /*,PathResolver.class*/)
		   .addAsManifestResource("META-INF/beans.xml","beans.xml")
		   .addAsServiceProvider(Extension.class,ControllerBeanExtension.class)
		   ;
	}

	@Test
	public void testResourceInjection() {
		assertNotNull(resources);
	}

	@Test
	public void testBeanResourceResolution() throws Exception {
		
	}
}
