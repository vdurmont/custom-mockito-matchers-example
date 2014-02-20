package com.github.vdurmont.service;

import com.github.vdurmont.model.Human;
import com.github.vdurmont.model.Message;

public class MyService {
	private final MessageService messageService;

	public MyService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void doStuff(Human author) {
		// TODO do complex stuff

		Message message = new Message(author);
		this.messageService.send(message);

		// TODO do complex stuff again
	}
}
