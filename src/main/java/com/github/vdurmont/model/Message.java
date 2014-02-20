package com.github.vdurmont.model;

public class Message {
	private final Human author;

	public Message(Human author) {
		this.author = author;
	}

	public Human getAuthor() {
		return author;
	}
}
