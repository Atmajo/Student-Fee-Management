package com.atmajo.server.repository;

import com.atmajo.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
