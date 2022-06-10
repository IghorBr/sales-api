package com.example.sales.entities.enums;

import lombok.Getter;

@Getter
public enum UserType {
	USER("ROLE_USER"),
	ADMIN("ROLE_ADMIN");
	
	private String description;
	
	private UserType(String desc) {
		this.description = desc;
	}
}
