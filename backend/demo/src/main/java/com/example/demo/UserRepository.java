package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

// This interface will be used to communicate with the database to do operations like saving, deleting, and finding users

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
