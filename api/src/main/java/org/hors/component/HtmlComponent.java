package org.hors.component;


public @interface HtmlComponent {

	Attribute[] attributes() default {};

}
