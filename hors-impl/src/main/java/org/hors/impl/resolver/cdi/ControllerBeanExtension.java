package org.hors.impl.resolver.cdi;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.inject.spi.ProcessBean;
import javax.enterprise.inject.spi.ProcessManagedBean;
import javax.enterprise.inject.spi.ProcessProducerField;
import javax.enterprise.inject.spi.ProcessProducerMethod;

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
	
	<X> void processAnnotatedType(@Observes ProcessAnnotatedType<X> event, BeanManager beanManager) {
		AnnotatedType<X> annotatedType = event.getAnnotatedType();
		System.out.println("Process annotated type: ["+annotatedType.getJavaClass().getName()+"]");
	}
	
    <X> void processBean(@Observes ProcessBean<X> event) {
		System.out.println("Process Bean: ["+event.getBean().getBeanClass().getName()+"]");
    }

    <X> void processManagedBean(@Observes ProcessManagedBean<X> event) {
		System.out.println("Process Managed Bean: ["+event.getBean().getBeanClass().getName()+"]");
    }

    <T, X> void processProducer(@Observes ProcessProducerMethod<T, X> event) {
		System.out.println("Process producer method for Bean: ["+event.getBean().getBeanClass().getName()+"]");
    }

    <T, X> void processProducer(@Observes ProcessProducerField<T, X> event) {
		System.out.println("Process producer field for Bean: ["+event.getBean().getBeanClass().getName()+"]");
    }

    void afterBeanDiscovery(@Observes AfterBeanDiscovery event, BeanManager manager) {
    	System.out.println("Discovery over");
    }
    
    void afterDeploymentValidation(@Observes AfterDeploymentValidation event) {
    	System.out.println("Deployment validation over");
    }

}
