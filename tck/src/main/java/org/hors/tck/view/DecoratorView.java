/**
 * 
 */
package org.hors.tck.view;

import java.awt.Component;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.hors.view.View;

/**
 * This view decorates any other created by CDI.
 * @author asmirnov
 *
 */
@Decorator
public class DecoratorView implements View {

	private final View delegate;

	@Inject
	public DecoratorView(@Delegate @Any View delegate) {
		this.delegate = delegate;
	}
	
	@Inject
	private Component navigation;
	
	@Inject
	private Component googleAnalitics;
	
}
