package org.hors.impl.resolver.pattern;

import static junit.framework.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.hors.impl.pattern.RequestMatcher;
import org.hors.impl.pattern.RequestPathPattern;
import org.hors.servlet.WebRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;


@RunWith(Parameterized.class)
public class RequestPathPatternTest {

	private final TestParameter parameterObject;
	
	@Mock
	WebRequest mockRequest;
	
	@Before public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
	
	public RequestPathPatternTest(TestParameter parameterObject) {
		this.parameterObject = parameterObject;
	}
	
	@Test
	public void testMatcher() throws Exception {
		RequestPathPattern pattern = new RequestPathPattern(parameterObject.pattern);
		RequestMatcher matcher = pattern.matcher(parameterObject.path, mockRequest);
		assertEquals(parameterObject.match, matcher.matches());
		if(parameterObject.match){
			for (String param : parameterObject.parameters.keySet()) {
				assertEquals(parameterObject.parameters.get(param), matcher.getParameter(param));
			}
		}
	}
	
	public static class TestParameter {
		public String pattern;
		public String path;
		public boolean match;
		public String tail;
		public final Map<String, String> parameters = Maps.newHashMap();
		public TestParameter pp(String name, String value) {
			this.parameters.put(name, value);
			return this;
		}
	}

	@Parameters
	public static List<Object[]> parameters(){
		return of(p("foo","foo",true,""),
				p("foo/","foo/bar",true,"bar"),
				p("baz/foo","foo",false,""),
				p("foo/(?<id>.+)/","foo/12/bar",true,"bar").pp("id","12"));
	}
	
	public static List<Object[]> of(Object ...objects){
		Builder<Object[]> builder = ImmutableList.<Object[]>builder();
		for (Object object : objects) {
			builder.add(new Object[]{object});
		}
		return builder.build();
	}
	
	public static TestParameter p(String pattern, String path, boolean match,
			String tail) {
		TestParameter param = new TestParameter();
		param.pattern = pattern;
		param.path = path;
		param.match = match;
		param.tail = tail;
		return param;
	}

}
