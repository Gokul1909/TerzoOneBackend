package com.terzoOne.terzoOneBackend.repository;

import com.terzoOne.terzoOneBackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
