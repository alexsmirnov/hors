package org.hors.tck.template;

import javax.inject.Inject;

import org.hors.tck.controller.Mobile;
import org.hors.template.Template;
import org.hors.template.TemplateResolver;

/**
 * If {@link Mobile} Stereotype is active, this resolver will be used.
 * It's simple delegates all calls to default resolver with "mobile" prefix.
 * @author asmirnov
 *
 */
@Mobile
public class StereotypeTemplateResolver implements TemplateResolver {

	private final TemplateResolver defaultResolver;

	@Inject
	public StereotypeTemplateResolver(TemplateResolver defaultResolver) {
		this.defaultResolver = defaultResolver;
	}

	@Override
	public Template resolve(String id) {
		return defaultResolver.resolve("/mobile"+id);
	}

}
