package org.hors.component;

/**
 * Implementation of this interface used to transform html/xml attributes.
 * If attribute defined in the template, it will be replaced by result of {@link #append(String)}
 * method call.
 * Otherwise, result of the {@link #get()} method used as attribute value.
 * Null value tells framework to remove target attribute. 
 * @author asmirnov
 *
 */
public interface AttributeProcessor {
	/**
	 * Append some value to existing attribute
	 * @param attr attribute value defined in template.
	 * @return converted attribute value.
	 */
	String append(String attr);

	/**
	 * 
	 * @return attribute value
	 */
	String get();

}
