package com.example.repository;

import com.example.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserCredentials, Long>{
    @Query("select u from UserCredentials u")
    List<UserCredentials> findByName(String name);

    @Query("select u from UserCredentials u")
    List<UserCredentials> findByNameEquals(String name);

}
