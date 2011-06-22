package org.hors.impl.resolver.cdi;

import javax.enterprise.inject.spi.Extension;

import org.hors.impl.resolver.ControllerBean;
import org.hors.impl.resolver.pattern.RequestPattern;
import org.hors.resolver.Resolver;

/**
 * This extension resolves CDI beans marked as {@link Resolver} or {@link RequestPattern}.
 * For each bean, it creates {@link RequestPattern} that describes requests processed by bean
 * and {@link ControllerBean} used to lookup and call controller methods.
 * @author asmirnov
 *
 */
public class ControllerBeanExtension implements Extension {

}
