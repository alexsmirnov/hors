package org.hors.tck.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.hors.binding.Bind;
import org.hors.component.AttributeProcessor;
import org.hors.component.Component;
import org.hors.component.HtmlComponent;
import org.hors.component.Repeat;

public class Navigation implements Component {

	@Inject
	@Bind(el="#{mybean.pages}")
	Repeat<String> iterator; 
	
	@Inject
	HtmlComponent link;
	
	@PostConstruct
	public void init(){
		link.setAttribute("href",new AttributeProcessor(){
			public String append(String attr){
				return iterator.getRow();
			}
			public String get(){
				return iterator.getRow();
			}
		});
	}
}
