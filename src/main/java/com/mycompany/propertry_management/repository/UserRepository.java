package com.mycompany.propertry_management.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.propertry_management.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByOwnerEmailAndPassword(String email, String password);
    Optional<UserEntity> findByOwnerEmail(String email);

}
