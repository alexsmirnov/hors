/**
 * 
 */
package org.hors.tck.viewresolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.inject.Stereotype;

/**
 * This annotation marks mobile version of web application.
 * @author asmirnov
 *
 */
@Stereotype
@Target(ElementType.TYPE) 
@Retention(RetentionPolicy.RUNTIME)
public @interface Mobile {

}
