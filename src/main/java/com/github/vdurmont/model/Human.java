package com.github.vdurmont.model;

public class Human {
	private final String name;
	private final Gender gender;

	public Human(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}
}
