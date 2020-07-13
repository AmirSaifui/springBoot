package com.firstWebService.rest.services.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class todoHardcodedService {
	
	private static List<Todo> todos=new ArrayList<Todo>();
	private static long idCounter=0;
	
	static {
		todos.add(new Todo(++idCounter,"amir","learn to dev",new Date(),false));
		todos.add(new Todo(++idCounter,"amir","earn more",new Date(),false));
		todos.add(new Todo(++idCounter,"amir","realise my dreams",new Date(),false));
	}
	
	public List<Todo> findall(){
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo desiredTodo=findById(id);
		if(todos.remove(desiredTodo)) return desiredTodo;
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo findById(long id) {
	
		for(Todo todo:todos) {
			if(todo.getId()==id)return todo;
		}
		return null;
	}
	
}
