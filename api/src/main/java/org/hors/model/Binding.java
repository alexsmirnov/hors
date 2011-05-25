package org.hors.model;

public interface Binding <T> {

	void set(T newValue);
	
	T get();
}
