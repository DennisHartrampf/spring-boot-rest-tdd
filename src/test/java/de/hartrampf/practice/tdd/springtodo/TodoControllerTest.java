package de.hartrampf.practice.tdd.springtodo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class TodoControllerTest {

    private TodoController controller;
    
    @Mock
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new TodoController(todoService);
    }

    @Test
    void todoListShouldBeEmptyInitially() {
        assertThatGetTodosContainsExactly();
        assertThatGetTodosContainsExactly(new Todo("1", true), new Todo("2", true), new Todo("3", false));
    }

    private void assertThatGetTodosContainsExactly(Todo... expectedTodos) {
        final List<Todo> todoList = Arrays.asList(expectedTodos);
        when(todoService.getTodos()).thenReturn(todoList);
        
        ResponseEntity<List<Todo>> actualTodos = controller.getTodos();
        
        assertThat(actualTodos.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualTodos.getBody()).isEqualTo(todoList);
    }

    @Test
    void testGetTodoByIndex() {
        final Todo todo = new Todo("1", true);
        when(todoService.getTodo(anyInt())).thenReturn(todo);

        final ResponseEntity<Todo> responseEntity = controller.getTodo(0);
        
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(todo);
    }

}
