package org.hors.impl.resolver.pattern;

import static org.junit.Assert.*;

import java.util.List;

import org.hors.impl.resolver.pattern.RequestPathPatternTest.TestParameter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

@RunWith(Parameterized.class)
public class PatternOrderTest {
	
	private final RequestPattern first;
	private final RequestPattern second;
	private final int result;

	public PatternOrderTest(RequestPattern first, RequestPattern second,int result) {
		this.first = first;
		this.second = second;
		this.result = result;
	}

	@Test
	public void testCompareFirstToSecond() {
		assertEquals(result,Integer.signum(first.compareTo(second)));
	}

	@Test
	public void testCompareSecondToFirst() {
		assertEquals(-1*result,Integer.signum(second.compareTo(first)));
	}

	@Parameters
	public static List<Object[]> parameters(){
		return of(
				testSame(a(),a()),
				testLess(a(),p("foo/")),
				testLess(p("foo/"),p("foo/bar")),
				testLess(p("foo/(?<param>.*)"),p("foo/bar")),
				testLess(p("foo/"),p("foo/(?<param>.*)"))
				);
	}
	
	public static List<Object[]> of(Object[] ...tests){
		return ImmutableList.copyOf(tests);
	}
	
	public static Object[] testSame(RequestPattern first, RequestPattern second ) {
		return new Object[]{first,second,0};
	}

	public static Object[] testLess(RequestPattern first, RequestPattern second ) {
		return new Object[]{first,second,-1};
	}
	

	public static RequestPathPattern p(String pattern){
		return new RequestPathPattern(pattern);
	}
	
	public static AnyPathPattern a(){
		return AnyPathPattern.INSTANCE;
	}

}
