package com.example.week7_task.dao;

import com.example.week7_task.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDAO extends JpaRepository<Users, Integer> {
        Users findByEmail(String email);

        @Query(value = "select fullname,id From users",nativeQuery = true)
    List<Users> fetchUser();

}
