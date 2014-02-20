package com.github.vdurmont;

import com.github.vdurmont.model.Human;
import com.github.vdurmont.model.Message;
import org.mockito.ArgumentMatcher;

import static org.mockito.Matchers.argThat;

public class AuthorMatcher extends ArgumentMatcher<Message> {
	public static Message authorIs(Human author) {
		return argThat(new AuthorMatcher(author));
	}

	private final Human expected;

	public AuthorMatcher(Human author) {
		this.expected = author;
	}

	@Override
	public boolean matches(Object argument) {
		if (argument == null) return false;
		if (!(argument instanceof Message)) return false;

		Message msg = (Message) argument;
		if (expected == null) return msg.getAuthor() == null;

		Human author = msg.getAuthor();

		if (expected.getName() == null) return author.getName() == null;
		if (!expected.getName().equals(author.getName())) return false;

		if (expected.getGender() == null) return author.getGender() == null;
		return expected.getGender().equals(author.getGender());
	}
}
