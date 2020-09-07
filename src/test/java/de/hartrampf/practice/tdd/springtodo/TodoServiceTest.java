package de.hartrampf.practice.tdd.springtodo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TodoServiceTest {

    private TodoService todoService;

    @BeforeEach
    void setUp() {
        todoService = new TodoService();
    }

    @Test
    void getTodosShouldBeEmptyInitially() {
        assertThat(todoService.getTodos()).isEmpty();
    }
    
    @Test
    void afterAddingTodoGetTodosShouldContainIt() {
        final Todo todo1 = new Todo("1", true);
        final Todo todo2 = new Todo("2", false);
        todoService.addTodo(todo1);
        todoService.addTodo(todo2);
        
        assertThat(todoService.getTodos()).containsExactly(todo1, todo2);
    }

    @Test
    void shouldGetTodoByIndex() {
        final Todo todo1 = new Todo("1", true);
        final Todo todo2 = new Todo("2", false);
        todoService.addTodo(todo1);
        todoService.addTodo(todo2);

        assertThat(todoService.getTodo(0)).isEqualTo(todo1);
        assertThat(todoService.getTodo(1)).isEqualTo(todo2);
    }
    
}
