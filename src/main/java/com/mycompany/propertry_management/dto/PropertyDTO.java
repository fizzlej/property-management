package com.mycompany.propertry_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private Long Id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private String address;
    private Double price;

}
