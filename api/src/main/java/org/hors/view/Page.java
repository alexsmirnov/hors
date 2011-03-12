/**
 * 
 */
package org.hors.view;

/**
 * This annotation defines JavaBean as {@link HorsView} controller. 
 * @author asmirnov
 *
 */
public @interface Page {
	/**
	 * @return Hors viewId. By default, it's java class file path with ".html" extension.
	 */
	String id() default "";
	
	/**
	 * @return View template id. By default, template id is the same as viewId.
	 */
	String template() default "";
}
