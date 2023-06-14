package com.ead.authuser.repositories;

import com.ead.authuser.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByUsername(String userName);
    boolean existsByEmail(String email);
}
