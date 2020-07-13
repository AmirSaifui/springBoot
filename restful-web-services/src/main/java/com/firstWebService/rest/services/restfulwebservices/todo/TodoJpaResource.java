package com.firstWebService.rest.services.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:6969")
public class TodoJpaResource {

	@Autowired
	private todoHardcodedService todoService;

	@Autowired
	private TodoJpaRepository todoJparepo;

	@GetMapping(path = "jpa/users/{username}/todos")
	public List<Todo> retreiveAllTodos(@PathVariable String username) {
		return todoJparepo.findByUsername(username);
//		return todoService.findall();
	}

	@GetMapping(path = "jpa/users/{username}/todos/{id}")
	public Todo retreiveTodo(@PathVariable String username, @PathVariable long id) {
		return todoJparepo.findById(id).get();
//		return todoService.findById(id);
	}

	@DeleteMapping(path = "jpa/users/{username}/todos/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable String username, @PathVariable long id) {
		todoJparepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {
		todo.setUsername(username);
		Todo todoUpdated = todoJparepo.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);

	}

	@PostMapping(path = "jpa/users/{username}/todos")
	public ResponseEntity<?> createTodo(@PathVariable String username, @RequestBody Todo todo) {
		todo.setUsername(username);
		Todo createdTodo = todoService.save(todo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();

		return ResponseEntity.created(uri).build();

	}
}
