package com.myclass.todo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.todo.entity.HelloWorldBean;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/hello-world")
public class HelloWorldController {
	
	@GetMapping
	public String helloWorld() {
		return "hello-world";
	}
	@GetMapping("/bean")
	public HelloWorldBean helloWordBean() {
		HelloWorldBean message = new HelloWorldBean();
		message.setMessage("Hello world");
		return message;
		
	}
	
	@GetMapping("/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable(value = "name") String name) {
		HelloWorldBean message = new HelloWorldBean();
		message.setMessage("Hello world " + name);
		return message;
	}
	
}
	