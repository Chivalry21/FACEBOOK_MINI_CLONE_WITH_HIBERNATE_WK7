package com.example.week7_task.dao;

import com.example.week7_task.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO extends JpaRepository<Posts,Integer> {
}

