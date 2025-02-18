package com.projectmanager.projectmanager.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanager.projectmanager.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
}
