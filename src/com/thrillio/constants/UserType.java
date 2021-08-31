package com.thrillio.constants;

public enum UserType {
	// private cnstructor used so can not instantiate class.
	USER("user"),
	EDITOR("editor"),
	CHIEF_EDITOR("chiefeditor");
	String name;
	private UserType(String name) {
		this.name = name;
	}
}
