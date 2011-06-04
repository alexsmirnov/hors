/**
 * 
 */
package org.hors.tck.resolver;

import javax.inject.Inject;

import org.hors.resolver.Handler;
import org.hors.resolver.Redirect;
import org.hors.resolver.RequestPath;
import org.hors.tck.view.LoginPage;
import org.hors.view.View;

/**
 * This resolver used when not authenticated user tries to get protected page.
 * @author asmirnov
 *
 */
@NotLoggedIn
@RequestPath("/protected/")
public class StereotypeActivatedResolver{

	private final LoginPage loginPage;

	@Inject
	public StereotypeActivatedResolver(LoginPage loginPage) {
		this.loginPage = loginPage;
	}

	@RequestPath("{any}")
	public LoginPage find() {
		return loginPage;
	}

}
