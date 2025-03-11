package com.mycompany.propertry_management.converter;

import org.springframework.stereotype.Component;

import com.mycompany.propertry_management.dto.PropertyDTO;
import com.mycompany.propertry_management.entity.PropertyEntity;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOToEntity(PropertyDTO propertyDTO){

        PropertyEntity pe = new PropertyEntity();

        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setPrice(propertyDTO.getPrice());
        
        return pe;
    }
    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity){

        PropertyDTO pd = new PropertyDTO();

        pd.setId(propertyEntity.getId());
        pd.setTitle(propertyEntity.getTitle());
        pd.setDescription(propertyEntity.getDescription());
        pd.setOwnerEmail(propertyEntity.getOwnerEmail());
        pd.setAddress(propertyEntity.getAddress());
        pd.setOwnerName(propertyEntity.getOwnerName());
        pd.setPrice(propertyEntity.getPrice());

        return pd;
    }

}
