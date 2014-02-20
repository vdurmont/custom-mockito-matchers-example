package com.github.vdurmont.service;

import com.github.vdurmont.model.Gender;
import com.github.vdurmont.model.Human;
import com.github.vdurmont.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.github.vdurmont.AuthorMatcher.authorIs;
import static com.github.vdurmont.MaleMatcher.authorIsAMale;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class MyServiceTest {
	@Test
	public void doStuff_sends_a_message() {
		// GIVEN
		MessageService mockMessageService = mock(MessageService.class);
		MyService service = new MyService(mockMessageService);

		Human author = new Human("Vincent", Gender.MALE);

		// WHEN
		service.doStuff(author);

		// THEN
		verify(mockMessageService).send(any(Message.class));
	}

	@Test
	public void doStuff_sends_a_message_from_a_male() {
		// GIVEN
		MessageService mockMessageService = mock(MessageService.class);
		MyService service = new MyService(mockMessageService);

		Human author = new Human("Vincent", Gender.MALE);

		// WHEN
		service.doStuff(author);

		// THEN
		verify(mockMessageService).send(authorIsAMale());
	}

	@Test
	public void doStuff_sends_a_message_from_the_given_author() {
		// GIVEN
		MessageService mockMessageService = mock(MessageService.class);
		MyService service = new MyService(mockMessageService);

		Human author = new Human("Vincent", Gender.MALE);

		// WHEN
		service.doStuff(author);

		// THEN
		verify(mockMessageService).send(authorIs(author));
	}
}
