package de.hartrampf.practice.tdd.springtodo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TodoTest {

    @Test
    void testProperties() {
        Todo todo = new Todo("Finish tests", true);
        assertThat(todo.getSubject()).isEqualTo("Finish tests");
        assertThat(todo.isDone()).isTrue();
        
        todo = new Todo("Finish prod code", false);
        assertThat(todo.getSubject()).isEqualTo("Finish prod code");
        assertThat(todo.isDone()).isFalse();
    }

    @Test
    void testEqualsAndHashcode() {
        Todo todo1 = new Todo("Finish tests", true);
        Todo todo2 = new Todo("Finish tests", true);
        assertThat(todo1).isEqualTo(todo2);
        assertThat(todo1).hasSameHashCodeAs(todo2);
    }

}
