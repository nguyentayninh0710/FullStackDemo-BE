package com.myclass.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.todo.entity.Todo;
import com.myclass.todo.service.TodoHardCodedService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/todo")
public class TodoController {
	
	@Autowired
	private TodoHardCodedService todoService;
	
	
	@GetMapping("/{username}")
	public List<Todo> getAllTodos(@PathVariable( value = "username") String username){
		return todoService.findAll();
	}
	
	@GetMapping("/{username}/{id}")
	public Todo getTodo(@PathVariable( value = "username") String username,
							  @PathVariable( value = "id") long id){
		return todoService.findById(id);
	}
	
	@PutMapping("/{username}/{id}")
	public ResponseEntity<Todo> update(@PathVariable( value = "username") String username,
			   @PathVariable( value = "id") long id, @RequestBody Todo todo){
		Todo todoCreate = todoService.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/{username}")
	public ResponseEntity<Todo> create(@PathVariable( value = "username") String username, @RequestBody Todo todo){
		Todo todoUpdate = todoService.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{username}/{id}")
	public ResponseEntity<Void> delete(@PathVariable( value = "username") String username,
									   @PathVariable( value = "id") long id){
		Todo todo = todoService.delete(id);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
