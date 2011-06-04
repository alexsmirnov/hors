/**
 * 
 */
package org.hors.resolver;

import javax.ws.rs.Path;

/**
 * Defines request path pattern for Hors view.
 * @see {@link Path} for details.
 * @author asmirnov
 *
 */
public @interface RequestPath {
	String value();
}
