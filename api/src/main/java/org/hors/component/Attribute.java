package org.hors.component;

public @interface Attribute {
	
	String name();
	
	String value() default "";

}
