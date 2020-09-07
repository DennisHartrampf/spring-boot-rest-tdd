package de.hartrampf.practice.tdd.springtodo;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {
    
    // This would usually be outsourced to a repository - but for simplicity it stays here.
    private final List<Todo> todos = new ArrayList<>();
    
    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public Todo getTodo(int index) {
        return todos.get(index);
    }
}
