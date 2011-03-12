/**
 * 
 */
package org.hors.view;

import javax.faces.component.UIViewRoot;

/**
 * Implementation of this interface wraps JSF view. 
 * @author asmirnov
 *
 */
public interface FacesView extends View {

	/**
	 * @return JSF viewId {@link UIViewRoot#getViewId()}
	 */
	String getViewId();
}
