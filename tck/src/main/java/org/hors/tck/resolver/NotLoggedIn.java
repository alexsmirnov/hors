/**
 * 
 */
package org.hors.tck.resolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.inject.Stereotype;

/**
 * This annotation defines stereotype for application state with
 * unauthenticated user.
 * @author asmirnov
 *
 */
@Stereotype
@Target(ElementType.TYPE) 
@Retention(RetentionPolicy.RUNTIME)
public @interface NotLoggedIn {

}
