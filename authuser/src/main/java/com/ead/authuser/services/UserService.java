package com.ead.authuser.services;

import com.ead.authuser.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(UUID userId);

    void delete(UserEntity userEntity);
}
