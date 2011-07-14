package org.hors.impl.resolver;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.hors.servlet.WebRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ResolverTest {


	@Mock
	ResourceDescription resource;
	
	@Mock
	WebRequest request;
	
	
	@Test
	public void testResolvePath() throws Exception {
		when(request.getPath()).thenReturn(TestBean.FOO_BAR);
		when(resource.resolve(Matchers.<VisitContext>any())).thenReturn(new TestBean("TestBean"));
		BeanResourceResolver resolver = new BeanResourceResolver(resource);
		Object resolved = resolver.resolve(request);
		assertNotNull(resolved);
		assertTrue(resolved instanceof TestBean);
		assertEquals("TestBean", ((TestBean)resolved).getName());
	}
}
