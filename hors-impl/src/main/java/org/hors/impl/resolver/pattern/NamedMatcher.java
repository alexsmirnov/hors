package org.hors.impl.resolver.pattern;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class NamedMatcher {

	private final Matcher matcher;
	private final NamedPattern parentPattern;

	NamedMatcher(NamedPattern parentPattern, Matcher matcher) {
		this.parentPattern = parentPattern;
		this.matcher = matcher;
	}

	public NamedMatcher reset() {
		matcher.reset();
		return this;
	}

	public boolean matches() {
		return matcher.matches();
	}

	public boolean find() {
		return matcher.find();
	}

	public boolean find(int start) {
		return matcher.find(start);
	}

	public boolean lookingAt() {
		return matcher.lookingAt();
	}

	public String group() {
		return matcher.group();
	}

	public String group(int group) {
		return matcher.group(group);
	}

	public int groupCount() {
		return matcher.groupCount();
	}

	public String group(String groupName) {
		return group(groupIndex(groupName));
	}

	public Map<String, String> namedGroups() {
		Map<String, String> result = new LinkedHashMap<String, String>();

		for (int i = 1; i <= groupCount(); i++) {
			String groupName = parentPattern.groupNames().get(i - 1);
			String groupValue = matcher.group(i);
			result.put(groupName, groupValue);
		}

		return result;
	}

	private int groupIndex(String groupName) {
		return parentPattern.groupNames().indexOf(groupName) + 1;
	}

	public int start() {
		return matcher.start();
	}

	public int start(int group) {
		return matcher.start(group);
	}

	public int start(String groupName) {
		return start(groupIndex(groupName));
	}

	public int end() {
		return matcher.end();
	}

	public int end(int group) {
		return matcher.end(group);
	}

	public int end(String groupName) {
		return end(groupIndex(groupName));
	}

	public NamedMatcher region(int start, int end) {
		matcher.region(start, end);
		return this;
	}

	public int regionEnd() {
		return matcher.regionEnd();
	}

	public int regionStart() {
		return matcher.regionStart();
	}

	public boolean hitEnd() {
		return matcher.hitEnd();
	}

	public boolean requireEnd() {
		return matcher.requireEnd();
	}

	public boolean hasAnchoringBounds() {
		return matcher.hasAnchoringBounds();
	}

	public boolean hasTransparentBounds() {
		return matcher.hasTransparentBounds();
	}

	public String replaceAll(String replacement) {
		return matcher.replaceAll(replacement);
	}

	public String replaceFirst(String replacement) {
		return matcher.replaceFirst(replacement);
	}

	public NamedMatcher useAnchoringBounds(boolean b) {
		matcher.useAnchoringBounds(b);
		return this;
	}

	public NamedMatcher useTransparentBounds(boolean b) {
		matcher.useTransparentBounds(b);
		return this;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matcher == null) ? 0 : matcher.hashCode());
		result = prime * result
				+ ((parentPattern == null) ? 0 : parentPattern.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		NamedMatcher other = (NamedMatcher) obj;
		if (matcher == null) {
			if (other.matcher != null) {
				return false;
			}
		} else if (!matcher.equals(other.matcher)) {
			return false;
		}
		if (parentPattern == null) {
			if (other.parentPattern != null) {
				return false;
			}
		} else if (!parentPattern.equals(other.parentPattern)) {
			return false;
		}
		return true;
	}

	public String toString() {
		return matcher.toString();
	}

}
