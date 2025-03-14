package com.mycompany.propertry_management.service;

import java.util.List;

import com.mycompany.propertry_management.dto.PropertyDTO;

public interface PropertyService {

     PropertyDTO saveProperty(PropertyDTO propertyDTO);
     List<PropertyDTO> getAllProperties();
     PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
     PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);
     PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
     void deleteProperty(Long propertyId);
}
