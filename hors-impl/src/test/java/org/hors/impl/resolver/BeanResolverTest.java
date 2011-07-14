package org.hors.impl.resolver;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.enterprise.inject.spi.Extension;
import javax.inject.Inject;

import org.hors.impl.resolver.cdi.ControllerBeanExtension;
import org.hors.resolver.ResourceResolver;
import org.hors.servlet.WebRequest;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;


@RunWith(Arquillian.class)
public class BeanResolverTest {

	
	@Inject
	BeanResourceResolver resolver;
	
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
		WebRequest request = Mockito.mock(WebRequest.class);
		when(request.getPath()).thenReturn(TestBean.FOO_BAR);
		Object resolved = resolver.resolve(request);
		assertNotNull(resolved);
		assertTrue(resolved instanceof TestBean);
		Mockito.validateMockitoUsage();
	}
}
