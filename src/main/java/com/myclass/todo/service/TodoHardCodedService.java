package com.myclass.todo.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.todo.entity.Todo;

@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter ,"nguyenhuynh", "demo1", new Date(), false));
		todos.add(new Todo(++idCounter ,"nguyenhuynh", "demo2", new Date(), true));
		todos.add(new Todo(++idCounter ,"nguyenhuynh", "demo3", new Date(), false));
	}
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			delete(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo delete(long id) {
		Todo todo = findById(id);
		if(todo == null) {
			return null;
		}else {
			todos.remove(todo);
			return todo;
		}
		
	}

	public Todo findById(long id) {
		for (int i = 0; i < todos.size(); i++) {
			if(todos.get(i).getId() == id){
				return todos.get(i);
			}
		}
		return null;
	}
}
