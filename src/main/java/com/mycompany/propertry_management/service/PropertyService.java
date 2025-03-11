package com.mycompany.propertry_management.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycompany.propertry_management.dto.PropertyDTO;
import com.mycompany.propertry_management.entity.PropertyEntity;

public interface PropertyService {

     PropertyDTO saveProperty(PropertyDTO propertyDTO);
     List<PropertyDTO> getAllProperties();
     PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
     PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);
     PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
     void deleteProperty(Long propertyId);
}
