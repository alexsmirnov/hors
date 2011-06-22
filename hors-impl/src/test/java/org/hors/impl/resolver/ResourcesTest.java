package org.hors.impl.resolver;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.Map;

import org.hors.impl.pattern.AnyPathPattern;
import org.hors.impl.pattern.RequestPathPattern;
import org.hors.impl.pattern.RequestPattern;
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
	public void testMathodResource(){
		Resources resources = createResources();
		VisitParameters params = new VisitParameters("foo/baz/method",request);
		Object apply = resources.apply(visitor, params);
		assertEquals(METHOD, apply);
	}

	@Test
	public void testBeanResource(){
		Resources resources = createResources();
		VisitParameters params = new VisitParameters("foo/bar",request);
		Object apply = resources.apply(visitor, params);
		assertEquals(BEAN, apply);
	}

	@Test
	public void testMissedResource(){
		Resources resources = createResources();
		VisitParameters params = new VisitParameters("bar/baz",request);
		Object apply = resources.apply(visitor, params);
		assertNull( apply);
	}

	private Resources createResources() {
		Map<RequestPattern, BeanDescription> beans = Maps.newTreeMap();
		ResourceBean resourceBean = new ResourceBean(bean);
		beans.put(new RequestPathPattern("bar"), resourceBean);
		when(visitor.visit(eq(resourceBean), Matchers.<VisitParameters>any())).thenReturn(BEAN);
		Map<RequestPattern, ControllerMethod> methods = Maps.newTreeMap();
		ControllerMethod controllerMethod = new ControllerMethod();
		methods.put(new RequestPathPattern("method"), controllerMethod);
		when(visitor.visit(eq(controllerMethod), Matchers.<VisitParameters>any())).thenReturn(METHOD);
		beans.put(new RequestPathPattern("baz/"), new ControllerBean(bean,methods));
		Map<RequestPattern, ResourcesPackage> packages = Maps.newTreeMap();
		packages.put(AnyPathPattern.INSTANCE, new ResourcesPackage(Collections.<RequestPattern, BeanDescription>emptyMap()));
		packages.put(new RequestPathPattern("foo/"), new ResourcesPackage(beans));
		Resources resources = new Resources(packages);
		return resources;
	}
}
