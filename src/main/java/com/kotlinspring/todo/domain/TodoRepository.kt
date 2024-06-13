package com.kotlinspring.todo.domain

import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {

    fun findAllByDoneIsFalseOrderByIdDesc(): List<Todo>?
}

//public interface TodoRepository extends JpaRepository<Todo, Long> {
//
//    Optional<List<Todo>> findAllByDoneIsFalseOrderByIdDesc();
//}
