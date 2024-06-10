package com.kotlinspring.todo.api

import com.kotlinspring.todo.api.model.TodoListResponse
import com.kotlinspring.todo.api.model.TodoRequest
import com.kotlinspring.todo.api.model.TodoResponse
import com.kotlinspring.todo.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService,
) {

    @GetMapping
    fun getAll() = ResponseEntity.ok(TodoListResponse.of(todoService.findAll()))

    @GetMapping("{id}")
    fun get(@PathVariable id: Long) = ResponseEntity.ok(todoService.findById(id))

    @PostMapping
    fun create(@RequestBody request: TodoRequest) =
        ResponseEntity.ok(TodoResponse.of(todoService.create(request)))

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody request: TodoRequest) =
        ResponseEntity.ok(TodoResponse.of(todoService.update(id, request)))

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Unit> {
        todoService.delete(id)
        return noContent().build()
    }
}

//package com.kotlinspring.todo.api
//
//@RestController
//@RequestMapping("/api/todos")
//class TodoController(private val todoService: TodoService) {
//    @get:GetMapping
//    val all: ResponseEntity<TodoListResponse>
//        get() {
//            val todos = todoService.findAll()
//            return ResponseEntity.ok(TodoListResponse.of(todos))
//        }
//
//    @GetMapping("/{id}")
//    fun get(@PathVariable id: Long?): ResponseEntity<TodoResponse> {
//        val todo = todoService.findById(id)
//        return ResponseEntity.ok(TodoResponse.of(todo))
//    }
//
//    @PostMapping
//    fun create(@RequestBody request: TodoRequest?): ResponseEntity<TodoResponse> {
//        val todo = todoService.create(request)
//        return ResponseEntity.ok(TodoResponse.of(todo))
//    }
//
//    @PutMapping("/{id}")
//    fun update(
//        @PathVariable id: Long?,
//        @RequestBody request: TodoRequest?
//    ): ResponseEntity<TodoResponse> {
//        val todo = todoService.update(id, request)
//        return ResponseEntity.ok(TodoResponse.of(todo))
//    }
//
//    @DeleteMapping("/{id}")
//    fun delete(@PathVariable id: Long?): ResponseEntity<Void> {
//        todoService.delete(id)
//        return noContent().build()
//    }
//}