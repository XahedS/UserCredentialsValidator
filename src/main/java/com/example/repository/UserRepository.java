package com.example.repository;

import com.example.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserCredential, Long>{
    @Query("select (count(u) > 0) from UserCredential u where u.name = :name")
    boolean existsByName(@Param("name") String name);
    @Query("select u from UserCredential u where u.name = :name")
    Optional<UserCredential> findByName(@Param("name") String name);

}
