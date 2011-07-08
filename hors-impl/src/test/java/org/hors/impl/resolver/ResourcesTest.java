package org.hors.impl.resolver;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.Map;

import org.hors.impl.resolver.pattern.AnyPathPattern;
import org.hors.impl.resolver.pattern.RequestPathPattern;
import org.hors.impl.resolver.pattern.RequestPattern;
import org.hors.servlet.WebRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Maps;


@RunWith(MockitoJUnitRunner.class)
public class ResourcesTest {


	private static final String BEAN = "BEAN";

	
	private static final String METHOD = "METHOD";

	@Mock
	ResourceDescriptionVisitor visitor;
	
	@Mock
	WebRequest request;
	
	@Mock
	javax.enterprise.inject.spi.Bean<?> bean;

	@Test
	public void testMethodResource(){
		Resources resources = createResources();
		VisitContext params = new VisitContext("foo/baz/method",request);
		Object apply = resources.apply(visitor, params);
		assertEquals(METHOD, apply);
	}

	@Test
	public void testBeanResource(){
		Resources resources = createResources();
		VisitContext params = new VisitContext("foo/bar",request);
		Object apply = resources.apply(visitor, params);
		assertEquals(BEAN, apply);
	}

	@Test
	public void testMissedResource(){
		Resources resources = createResources();
		VisitContext params = new VisitContext("bar/baz",request);
		Object apply = resources.apply(visitor, params);
		assertNull( apply);
	}

	private Resources createResources() {
		Map<RequestPattern, ResourceDescription> beans = Maps.newTreeMap();
		ResourceBean resourceBean = new ResourceBean(bean);
		beans.put(new RequestPathPattern("bar"), resourceBean);
		when(visitor.visit(same(resourceBean), Matchers.<VisitContext>any())).thenReturn(BEAN);
		Map<RequestPattern, ResourceDescription> methods = Maps.newTreeMap();
		ResourceBean controllerMethod = new ResourceBean(bean);
		methods.put(new RequestPathPattern("method"), controllerMethod);
		when(visitor.visit(same(controllerMethod), Matchers.<VisitContext>any())).thenReturn(METHOD);
		beans.put(new RequestPathPattern("baz/"), new Resources(methods));
		Map<RequestPattern, ResourceDescription> packages = Maps.newTreeMap();
		packages.put(AnyPathPattern.INSTANCE, new Resources(Collections.<RequestPattern, ResourceDescription>emptyMap()));
		packages.put(new RequestPathPattern("foo/"), new Resources(beans));
		Resources resources = new Resources(packages);
		return resources;
	}
}
