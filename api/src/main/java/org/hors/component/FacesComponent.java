/**
 * 
 */
package org.hors.component;

/**
 * This interface delegates its functionality to JSF component.
 * @author asmirnov
 *
 */
public interface FacesComponent extends Component {
	/**
	 * @return JSF component type.
	 */
	String getComponentType();
}
