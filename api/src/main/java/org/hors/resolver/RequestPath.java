/**
 * 
 */
package org.hors.resolver;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.ws.rs.Path;

/**
 * Defines request path pattern for Hors view.
 * @see {@link Path} for details.
 * @author asmirnov
 *
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestPath {
	String value();
}
