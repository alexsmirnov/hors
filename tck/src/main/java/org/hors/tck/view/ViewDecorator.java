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
public class ViewDecorator {

	private final Object delegate;

	@Inject
	public ViewDecorator(@Delegate Object delegate) {
		this.delegate = delegate;
	}
	
	@Inject
	private Navigation navigation;
	
	@Inject
	private Component googleAnalitics;
	
}
