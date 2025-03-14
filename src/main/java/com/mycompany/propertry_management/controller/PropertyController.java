package com.mycompany.propertry_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.propertry_management.dto.PropertyDTO;
import com.mycompany.propertry_management.service.PropertyService;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    //Get property configation information
    @Value("${pms.dummy}")
    private String dummy;
    
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

@PostMapping("/properties")
public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){

    propertyDTO = propertyService.saveProperty(propertyDTO);
    return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
   
}
@GetMapping("/properties")
public ResponseEntity<List<PropertyDTO>> getAllProperties(){

    //System.out.println(dummy);
    //System.out.println(dbUrl);

    List<PropertyDTO> propertyList = propertyService.getAllProperties();
    ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
    return responseEntity;
}
@PutMapping("/properties/{propertyId}")
public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){

    propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
    return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    
}
@PatchMapping("/properties/update-description/{propertyId}")
public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){

    propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
    return new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    
}
@PatchMapping("/properties/update-price/{propertyId}")
public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){

    propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
    return  new ResponseEntity<>(propertyDTO, HttpStatus.OK);
    
}
@SuppressWarnings("null")
@DeleteMapping("/properties/delete/{propertyId}")
public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId){

    propertyService.deleteProperty(propertyId);
    return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    
}
}
