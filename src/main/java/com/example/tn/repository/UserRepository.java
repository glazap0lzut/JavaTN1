package com.example.tn.repository;

import com.example.tn.Entity.Event;
import com.example.tn.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Long> {
}

