/**
 * 
 */
package org.hors.tck.viewresolver;

import javax.inject.Inject;

import org.hors.view.RequestPath;
import org.hors.view.View;
import org.hors.view.ViewResolver;

/**
 * This resolver used when not authenticated user tries to get protected page.
 * @author asmirnov
 *
 */
@NotLoggedIn
@RequestPath("/protected/*")
public class StereotypeActivatedViewResolver implements ViewResolver {

	private final View loginPage;
	private final ViewResolver defaultResolver;

	@Inject
	public StereotypeActivatedViewResolver(ViewResolver defaultResolver, View loginPage) {
		this.defaultResolver = defaultResolver;
		this.loginPage = loginPage;
	}
	/* (non-Javadoc)
	 * @see org.hors.view.ViewResolver#find(java.lang.String)
	 */
	@Override
	public View find(String viewId) {
		return loginPage;
	}

	/* (non-Javadoc)
	 * @see org.hors.view.ViewResolver#getRequestPath(org.hors.view.View)
	 */
	@Override
	public String getRequestPath(View view) {
		return defaultResolver.getRequestPath(view);
	}

}
