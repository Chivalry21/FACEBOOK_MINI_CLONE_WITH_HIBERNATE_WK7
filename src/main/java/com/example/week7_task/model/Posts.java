package com.example.week7_task.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String authorId;

    @Column(nullable = false)
    private String tittle;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "int default 0")
    private  int likes;

    @Column(nullable = false)
    private  String likedBy;

    @Column(nullable = false)
    private String dateCreated;


}
