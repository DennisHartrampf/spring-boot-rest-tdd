package de.hartrampf.practice.tdd.springtodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(todoService.getTodos());
    }
    
    @GetMapping(path = "todo/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> getTodo(@PathVariable("index") int index) {
        return ResponseEntity.ok(todoService.getTodo(index));
    }
}
