package com.mycompany.propertry_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.propertry_management.entity.PropertyEntity;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

}
