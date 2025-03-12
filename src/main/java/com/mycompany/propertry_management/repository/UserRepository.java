package com.mycompany.propertry_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.propertry_management.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
