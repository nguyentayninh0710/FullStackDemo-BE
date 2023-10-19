package com.myclass.todo.entity;

import lombok.Data;

@Data
public class HelloWorldBean {
	private String message;
	
	
	
	@Override
	public String toString() {
		return String.format("HelloWorld [message=%s]", message);
		
	}
}
