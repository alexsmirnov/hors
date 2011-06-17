package org.hors.impl.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamedPattern {

	private static final Pattern NAMED_GROUP_PATTERN = Pattern
			.compile("\\(\\?<(\\w+)>",Pattern.MULTILINE);

	private final Pattern pattern;
	private final String namedPattern;
	private final List<String> groupNames;

	private final int flags;

	public static NamedPattern compile(String regex) {
		return new NamedPattern(regex, 0);
	}

	public static NamedPattern compile(String regex, int flags) {
		return new NamedPattern(regex, flags);
	}

	private NamedPattern(String regex, int i) {
		namedPattern = regex;
		flags = i;
		pattern = buildStandardPattern(regex,flags);
		groupNames = extractGroupNames(regex);
	}

	public int flags() {
		return pattern.flags();
	}

	public NamedMatcher matcher(CharSequence input) {
		return new NamedMatcher(this, pattern.matcher(input));
	}

	public List<String> groupNames() {
		return groupNames;
	}

	static List<String> extractGroupNames(String namedPattern) {
		List<String> groupNames = new ArrayList<String>();
		Matcher matcher = NAMED_GROUP_PATTERN.matcher(namedPattern);
		while (matcher.find()) {
			groupNames.add(matcher.group(1));
		}
		return groupNames;
	}

	static Pattern buildStandardPattern(String namedPattern,int flags) {
		return Pattern.compile(NAMED_GROUP_PATTERN.matcher(namedPattern)
				.replaceAll("("),flags);
	}

	@Override
	public String toString() {
		return namedPattern;
	}
}
