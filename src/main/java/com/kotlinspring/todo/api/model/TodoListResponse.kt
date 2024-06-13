package com.kotlinspring.todo.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.kotlinspring.todo.domain.Todo

data class TodoListResponse(
    val items: List<TodoResponse>
) {

    val size: Int
        @JsonIgnore
        get() = items.size

    fun get(index: Int) = items[index]

    companion object {
        fun of (todoList: List<Todo>) =
            TodoListResponse(todoList.map {TodoResponse.of(it)} )
    }
}

//package com.kotlinspring.todo.api.model;
//
//import com.kotlinspring.todo.domain.Todo;
//import java.util.List;
//import java.util.stream.Collectors;
//import lombok.Data;
//
//@Data
//public class TodoListResponse {
//
//    private final List<TodoResponse> items;
//
//    private TodoListResponse(List<TodoResponse> items) {
//        this.items = items;
//    }
//
//    public int size() {
//        return items.size();
//    }
//
//    public TodoResponse get(int index) {
//        return items.get(index);
//    }
//
//    public static TodoListResponse of(List<Todo> todoList) {
//        List<TodoResponse> todoListResponse = todoList.stream()
//            .map(TodoResponse::of)
//            .collect(Collectors.toList());
//
//        return new TodoListResponse(todoListResponse);
//    }
//
//}
