package com.github.vdurmont;

import com.github.vdurmont.model.Gender;
import com.github.vdurmont.model.Message;
import org.mockito.ArgumentMatcher;

import static org.mockito.Matchers.argThat;

public class MaleMatcher extends ArgumentMatcher<Message> {
	public static Message authorIsAMale() {
		return argThat(new MaleMatcher());
	}

	@Override
	public boolean matches(Object argument) {
		// TODO check null, etc.
		return Gender.MALE.equals(((Message) argument).getAuthor().getGender());
	}
}
