/**
 * 
 */
package org.hors.binding;

/**
 * @author asmirnov
 *
 */
public @interface Service {
	/**
	 * @return class for JAX-RS endpoint implementation.
	 */
	Class<?> value();
	
	String method() default "";
}
