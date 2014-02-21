package com.github.vdurmont;

import com.github.vdurmont.model.Message;
import org.mockito.ArgumentMatcher;

import static org.mockito.Matchers.argThat;

public class AuthorNameMatcher extends ArgumentMatcher<Message> {
	public static Message authorNameStartsWith(String startsWith) {
		return argThat(new AuthorNameMatcher(startsWith));
	}

	private final String expected;

	public AuthorNameMatcher(String expected) {
		this.expected = expected;
	}

	@Override
	public boolean matches(Object argument) {
		// TODO check null, etc.
		String actual = ((Message) argument).getAuthor().getName().toLowerCase();
		return actual.startsWith(expected.toLowerCase());
	}
}
