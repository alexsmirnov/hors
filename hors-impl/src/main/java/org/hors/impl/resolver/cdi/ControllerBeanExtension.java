package org.hors.impl.resolver.cdi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.hors.impl.resolver.ResourceBean;
import org.hors.impl.resolver.ResourceDescription;
import org.hors.impl.resolver.Resources;
import org.hors.impl.resolver.pattern.RequestPathPattern;
import org.hors.impl.resolver.pattern.RequestPattern;
import org.hors.resolver.RequestPath;
import org.hors.resolver.Resolver;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * This extension resolves CDI beans marked as {@link Resolver} or {@link RequestPattern}.
 * For each bean, it creates {@link RequestPattern} that describes requests processed by bean
 * and {@link ControllerBean} used to lookup and call controller methods.
 * @author asmirnov
 *
 */
public class ControllerBeanExtension implements Extension {
	
	private boolean discoveryOver = false;
	
	private List<ControllerBean<?>> managedBeans = Lists.newArrayList();
	
	<X> void processAnnotatedType(@Observes ProcessAnnotatedType<X> event, BeanManager beanManager) {
		AnnotatedType<X> annotatedType = event.getAnnotatedType();
		System.out.println("Process annotated type: ["+annotatedType.getJavaClass().getName()+"]");
	}
	
    <X> void processBean(@Observes ProcessBean<X> event) {
		System.out.println("Process Bean event ["+event.getClass()+"] for bean class: ["+event.getBean().getBeanClass().getName()+"]");
    }

    <X> void processManagedBean(@Observes ProcessManagedBean<X> event) {
		System.out.println("Process Managed Bean: ["+event.getBean().getBeanClass().getName()+"]");
		if(!discoveryOver){
			AnnotatedType<X> annotatedBeanClass = event.getAnnotatedBeanClass();
			if(annotatedBeanClass.isAnnotationPresent(RequestPath.class)){
				managedBeans.add(new ControllerBean<X>(new RequestPathPattern(annotatedBeanClass.getAnnotation(RequestPath.class).value()), event.getBean()));
			}
		}
    }

    <T, X> void processProducer(@Observes ProcessProducerMethod<T, X> event) {
		System.out.println("Process producer method for Bean: ["+event.getBean().getBeanClass().getName()+"]");
    }

    <T, X> void processProducer(@Observes ProcessProducerField<T, X> event) {
		System.out.println("Process producer field for Bean: ["+event.getBean().getBeanClass().getName()+"]");
    }

    void afterBeanDiscovery(@Observes AfterBeanDiscovery event, BeanManager manager) {
    	this.discoveryOver = true;
    	event.addBean(new InstanceBean<ResourceDescription>(createResourcesDescription(manager), ResourceDescription.class));
    	System.out.println("Discovery over");
    }
    
    private ResourceDescription createResourcesDescription(BeanManager manager) {
    	Map<RequestPattern, ResourceDescription> beansMap = Maps.newTreeMap();
    	for(ControllerBean<?> controllerBean:managedBeans){
    		beansMap.put(controllerBean.getPattern(), new ResourceBean(controllerBean.getManagedBean(),manager));
    	}
		return new Resources(beansMap);
	}

	void afterDeploymentValidation(@Observes AfterDeploymentValidation event) {
    	System.out.println("Deployment validation over");
    }

}
