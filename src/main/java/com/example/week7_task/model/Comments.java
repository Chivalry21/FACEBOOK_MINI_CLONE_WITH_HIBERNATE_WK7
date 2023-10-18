package com.example.week7_task.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Comments {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String postId;
    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "Integer default 0")
    private Integer likes;

    private String likedBy;
    @Column(nullable = false)
    private String dateOfBirth;
}
