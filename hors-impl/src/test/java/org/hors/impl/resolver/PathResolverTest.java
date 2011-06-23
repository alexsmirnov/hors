package org.hors.impl.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.enterprise.inject.spi.Extension;
import javax.inject.Inject;

import org.hors.impl.resolver.cdi.ControllerBeanExtension;
import org.hors.resolver.ResourceResolver;
import org.hors.servlet.WebRequest;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@RunWith(Arquillian.class)
public class PathResolverTest {

	@Inject
	ResourceResolver resolver;
	
	@Mock
	WebRequest request;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void verifyMocks(){
		Mockito.validateMockitoUsage();
	}
	
	@Deployment
	public static JavaArchive deployment(){
		return ShrinkWrap.create(JavaArchive.class,"test.jar")
		   .addPackages(true, ResourceResolver.class.getPackage())
		   .addPackages(true, BeanResourceResolver.class.getPackage())
		   .addAsManifestResource("META-INF/beans.xml","beans.xml")
		   .addAsServiceProvider(Extension.class,ControllerBeanExtension.class)
		   ;
	}
	
	@Test
	public void testResolvePath() throws Exception {
		when(request.getPath()).thenReturn(Bean.FOO_BAR);
		Object resolved = resolver.resolve(request);
		assertTrue(resolved instanceof Bean);
	}
}
