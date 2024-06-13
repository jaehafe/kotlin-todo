package com.kotlinspring.todo.service

import com.kotlinspring.todo.api.model.TodoRequest
import com.kotlinspring.todo.domain.Todo
import com.kotlinspring.todo.domain.TodoRepository
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
class TodoService(
    private val todoRepository: TodoRepository,
) {

    @Transactional(readOnly = true)
    fun findAll(): List<Todo> {
        return todoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): Todo =
        todoRepository.findByIdOrNull(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)


    @Transactional
    fun create(request: TodoRequest?): Todo {
        checkNotNull(request) { "TodoRequest is null" }

        val todo = Todo(
            title = request.title,
            description = request.description,
            done = request.done,
            createdAt = LocalDateTime.now(),
        )

        return todoRepository.save(todo)
    }

    @Transactional
    fun update(id: Long, request: TodoRequest?): Todo {
        checkNotNull(request) { "TodoRequest is null" }

        return findById(id).let {
            it.update(request.title, request.description, request.done)
            todoRepository.save(it)
        }
    }

    fun delete(id: Long) = todoRepository.deleteById(id)
}



//@Service
//public class TodoService {
//
//    private final TodoRepository todoRepository;
//
//    public TodoService(TodoRepository todoRepository) {
//        this.todoRepository = todoRepository;
//    }
//
//    @Transactional(readOnly = true)
//    public List<Todo> findAll() {
//        return todoRepository.findAll(Sort.by(Direction.DESC, "id"));
//    }
//
//    @Transactional(readOnly = true)
//    public Todo findById(Long id) {
//        return todoRepository.findById(id)
//            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
//
//    @Transactional
//    public Todo create(TodoRequest request) {
//        Assert.notNull(request, "TodoRequest is null");
//
//        Todo todo = Todo.builder()
//            .title(request.getTitle())
//            .description(request.getDescription())
//            .done(false)
//            .createdAt(LocalDateTime.now())
//            .build();
//        return todoRepository.save(todo);
//    }
//
//    @Transactional
//    public Todo update(Long id, TodoRequest request) {
//        Assert.notNull(request, "TodoRequest is null");
//
//        Todo todo = findById(id);
//        todo.update(request.getTitle(),
//            request.getDescription(),
//            request.getDone());
//        return todoRepository.save(todo);
//    }
//
//    public void delete(Long id) {
//        todoRepository.deleteById(id);
//    }
//}
