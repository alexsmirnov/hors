package org.hors.view;

import java.lang.annotation.Annotation;

/**
 * Defines that setereotype should be activated.
 * @author asmirnov
 *
 */
public @interface Activate {
	Class<? extends Annotation> value();
}
