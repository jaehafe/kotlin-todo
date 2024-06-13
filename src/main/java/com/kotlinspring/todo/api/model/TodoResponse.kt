package com.kotlinspring.todo.api.model

import com.kotlinspring.todo.domain.Todo
import java.time.LocalDateTime

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String,
    val done: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {

    companion object {
        fun of(todo: Todo?): TodoResponse {
            checkNotNull(todo) { "Todo is null" }

            return TodoResponse(
                id = todo.id,
                title = todo.title,
                description = todo.description,
                done = todo.done,
                createdAt = todo.createdAt,
                updatedAt = todo.updatedAt
            )
        }
    }
}

//package com.kotlinspring.todo.api.model;
//
//import com.kotlinspring.todo.domain.Todo;
//import java.time.LocalDateTime;
//import lombok.Builder;
//import lombok.Data;
//import org.springframework.util.Assert;
//
//@Data
//@Builder
//public class TodoResponse {
//
//    private Long id;
//
//    private String title;
//
//    private String description;
//
//    private Boolean done;
//
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
//
//    public static TodoResponse of(Todo todo) {
//        Assert.notNull(todo, "Todo is null");
//
//        return TodoResponse.builder()
//            .id(todo.getId())
//            .title(todo.getTitle())
//            .description(todo.getDescription())
//            .done(todo.getDone())
//            .createdAt(todo.getCreatedAt())
//            .updatedAt(todo.getUpdatedAt())
//            .build();
//    }
//
//}
