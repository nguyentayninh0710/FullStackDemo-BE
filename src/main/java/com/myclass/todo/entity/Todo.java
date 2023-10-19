package com.myclass.todo.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Todo {
	private long id;
	private String username;
	private String description;
	private Date target;
	private boolean done;
	
	public Todo(long id, String username, String description, Date target, boolean done) {
		this.id = id;
		this.username = username;
		this.description = description;
		this.target = target;
		this.done = done;
	} 
	
	
}
