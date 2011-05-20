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
@RequestPath("/protected/.*")
public class StereotypeActivatedViewResolver{

	private final View loginPage;

	@Inject
	public StereotypeActivatedViewResolver(View loginPage) {
		this.loginPage = loginPage;
	}

	public View find() {
		return loginPage;
	}

}
