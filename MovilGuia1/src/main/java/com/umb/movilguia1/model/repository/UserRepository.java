package com.umb.movilguia1.model.repository;

import com.umb.movilguia1.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> getByEmail(String email);
}