package com.kotlinspring.todo.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table

@Entity
@Table(name = "todos")
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(name = "title")
    var title: String,

    @Lob
    @Column(name = "description")
    var description: String,

    @Column(name = "done")
    var done: Boolean,

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
) {

    fun update(title: String, description: String, done: Boolean) {
        this.title = title
        this.description = description
        this.done = done
        this.updatedAt = LocalDateTime.now()
    }
}


//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Builder
//@Entity
//@Table(name = "todos")
//public class Todo {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Lob
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "done")
//    private Boolean done;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    public void update(String title, String description, Boolean done) {
//        this.title = title;
//        this.description = description;
//        this.done = done != null && done;
//        this.updatedAt = LocalDateTime.now();
//    }
//}
