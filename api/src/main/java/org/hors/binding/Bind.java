/**
 * 
 */
package org.hors.binding;

/**
 * @author asmirnov
 *
 */
public @interface Bind {
	
	/**
	 * @return EL expression for binding.
	 */
	String el() default "" ;

	String name() default "";

}
