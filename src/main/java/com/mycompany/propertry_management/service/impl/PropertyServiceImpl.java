package com.mycompany.propertry_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycompany.propertry_management.converter.PropertyConverter;
import com.mycompany.propertry_management.dto.PropertyDTO;
import com.mycompany.propertry_management.entity.PropertyEntity;
import com.mycompany.propertry_management.repository.PropertyRepository;
import com.mycompany.propertry_management.service.PropertyService;







@Service
public class PropertyServiceImpl implements PropertyService {

    //Get property configation information
    @Value("${pms.dummy}")
    private String dummy;
    
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Autowired
    private PropertyConverter propertyConverter;
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO){

        PropertyEntity pe = propertyConverter.convertDTOToEntity(propertyDTO);
        pe = propertyRepository.save(pe);

        propertyDTO = propertyConverter.convertEntityToDTO(pe);

        return propertyDTO;

    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        System.out.println("Inside Service "+ dummy); //print out the property configuration information
        List<PropertyEntity> listOfProperties = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();

        for(PropertyEntity pe: listOfProperties){
            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
            propList.add(dto);
        }

        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        
       Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
       PropertyDTO dto = null;
       if(optEn.isPresent()){
        PropertyEntity pe = optEn.get();
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());
        pe.setPrice(propertyDTO.getPrice());
        
        dto = propertyConverter.convertEntityToDTO(pe);
        pe = propertyRepository.save(pe);
       }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        
        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
         PropertyEntity pe = optEn.get();
        
         pe.setDescription(propertyDTO.getDescription());
         dto = propertyConverter.convertEntityToDTO(pe);
         pe = propertyRepository.save(pe);
        }
         return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        
        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
         PropertyEntity pe = optEn.get();
        
         pe.setPrice(propertyDTO.getPrice());
         dto = propertyConverter.convertEntityToDTO(pe);
         pe = propertyRepository.save(pe);
        }
         return dto;

    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
   

}
