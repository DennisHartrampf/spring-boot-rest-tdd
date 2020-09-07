package de.hartrampf.practice.tdd.springtodo;

public class Todo {
    private final String subject;
    private final boolean done;

    public Todo(String subject, boolean done) {
        this.subject = subject;
        this.done = done;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Todo todo = (Todo) o;

        if (done != todo.done) {
            return false;
        }
        return subject != null ? subject.equals(todo.subject) : todo.subject == null;
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (done ? 1 : 0);
        return result;
    }
}
