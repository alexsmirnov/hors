package org.hors.impl.resolver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.hors.impl.resolver.Resources.builder;
import static org.hors.impl.resolver.pattern.RequestPatterns.anyRequest;
import static org.hors.impl.resolver.pattern.RequestPatterns.pathPattern;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.when;

import org.hors.servlet.WebRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ResourcesTest {


	private static final String BEAN = "BEAN";

	
	private static final String METHOD = "METHOD";
	
	@Mock
	WebRequest request;
	
	@Mock
	ResourceDescription methodDescription;

	@Mock
	ResourceDescription beanDescription;

	@Test
	public void testMethodResource(){
		Resources resources = createResources();
		VisitContext params = new VisitContext("foo/baz/method",request);
		Object apply = resources.resolve(params);
		assertEquals(METHOD, apply);
	}

	@Test
	public void testBeanResource(){
		Resources resources = createResources();
		VisitContext params = new VisitContext("foo/bar",request);
		Object apply = resources.resolve(params);
		assertEquals(BEAN, apply);
	}

	@Test
	public void testMissedResource(){
		Resources resources = createResources();
		VisitContext params = new VisitContext("bar/baz",request);
		Object apply = resources.resolve(params);
		assertNull(apply);
	}

	private Resources createResources() {
		when(beanDescription.resolve( Matchers.<VisitContext>any())).thenReturn(BEAN);
		when(methodDescription.resolve(Matchers.<VisitContext>any())).thenReturn(METHOD);
		Resources resources = builder()
			.put(pathPattern("foo/"), builder()
					.put(pathPattern("baz/"),builder()
							.put(pathPattern("method"),methodDescription)
							.build())
					.put(pathPattern("bar"),beanDescription)
					.build())
			.put(anyRequest(),builder().build())
			.build();
		return resources;
	}
}
