package org.hors.component;

import org.hors.component.AttributeProcessor;

public interface HtmlComponent extends Component {

	void setAttribute(String name, AttributeProcessor processor);

}
