package org.hors.impl.resolver.cdi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.weld.literal.DefaultLiteral;

import com.google.common.collect.ImmutableSet;

/**
 * Creates bean that always returns given instance.
 * 
 * @author asmirnov
 * 
 * @param <T>
 */
public final class InstanceBean<T> implements Bean<T> {

	private final T instance;
	private final ImmutableSet<Type> types;
	private final ImmutableSet<Annotation> qualifaers;

	public InstanceBean(T instance, Type type) {
		this(instance, type, DefaultLiteral.INSTANCE);
	}

	public InstanceBean(T instance, Type type, Annotation... qualifaers) {
		this.instance = instance;
		this.types = ImmutableSet.of(type);
		this.qualifaers = ImmutableSet.copyOf(qualifaers);
	}

	@Override
	public T create(CreationalContext<T> creationalContext) {
		creationalContext.push(instance);
		return instance;
	}

	@Override
	public void destroy(T instance, CreationalContext<T> creationalContext) {
		// Do nothing, the instance is never destroyed
	}

	@Override
	public Set<Type> getTypes() {
		return types;
	}

	@Override
	public Set<Annotation> getQualifiers() {
		return qualifaers;
	}

	@Override
	public Class<? extends Annotation> getScope() {
		return Dependent.class;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Set<Class<? extends Annotation>> getStereotypes() {
		return Collections.emptySet();
	}

	@Override
	public Class<?> getBeanClass() {
		return instance.getClass();
	}

	@Override
	public boolean isAlternative() {
		return false;
	}

	@Override
	public boolean isNullable() {
		return false;
	}

	@Override
	public Set<InjectionPoint> getInjectionPoints() {
		return Collections.emptySet();
	}

}
