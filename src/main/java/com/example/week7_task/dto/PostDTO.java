package com.example.week7_task.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {


    private int id;

    private String authorId;
    private String authorName;
    private String tittle;
    private String content;
    private int likes;
    private String likedBy;
    private String dateCreated;
}
