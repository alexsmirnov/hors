/**
 * 
 */
package org.hors.resolver;

/**
 * @author asmirnov
 *
 */
public @interface RequestParam {

	String name();
	
	String value() default "";
	
}
