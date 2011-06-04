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
 * This annotation marks mobile version of web application.
 * @author asmirnov
 *
 */
@Stereotype
@Target({ElementType.TYPE,ElementType.METHOD}) 
@Retention(RetentionPolicy.RUNTIME)
public @interface Mobile {

}
