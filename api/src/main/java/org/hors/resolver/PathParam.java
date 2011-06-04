/**
 * 
 */
package org.hors.resolver;

/**
 * @author asmirnov
 *
 */
public @interface PathParam {

	String name();
	
	String value() default "";
	
}
