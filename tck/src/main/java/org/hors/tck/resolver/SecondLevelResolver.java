/**
 * 
 */
package org.hors.tck.resolver;

import java.util.Collections;
import java.util.List;

import javax.enterprise.inject.New;
import javax.swing.text.html.FormView;

import org.hors.resolver.RequestParam;
import org.hors.resolver.RequestPath;
import org.hors.resolver.Resolver;
import org.hors.tck.model.Category;

/**
 * @author asmirnov
 *
 */
@Resolver
public class SecondLevelResolver {
	
	@RequestPath("")
	public List<Category> getAll(){
		return Collections.emptyList();
	}

	@RequestParam(name="edit")
	public FormView doEdit(@New FormView form){
		return form;
	}
}
