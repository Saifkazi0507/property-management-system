package com.example.property_management.controller;

import com.example.property_management.dto.PropertyDTO;
import com.example.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property") //Class level mapping of URL to Controller class
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    //Rest API = "Mapping Java Class Method to a particular URL"
    //http://localhost:8080/api/v1/property/hello

    @GetMapping("/hello")          //Method  level mapping of URL to Controller class
    public String hello()
    {
        return "Hello World!!!";
    }
    //http://localhost:8080/api/v1/property/project
    @GetMapping("/project")
    public String project()
    {
        return "This is my first Spring Boot Project!!!";
    }

    //http://localhost:8080/api/v1/property/properties

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO)
    {
        propertyDTO=propertyService.saveproperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    //http://localhost:8080/api/v1/property/properties
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties()
    {
        List<PropertyDTO> propertyList= propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity=new ResponseEntity<>(propertyList,HttpStatus.CREATED);
        return responseEntity;
    }

    //http://localhost:8080/api/v1/property/properties/(propertyId)
    @PutMapping("/properties/{propertyId}")
    public  ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId)
    {
      propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity =new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }


    //http://localhost:8080/api/v1/property/properties/update-description/(propertyId)
    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId)
    {
        propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity =new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }


    //http://localhost:8080/api/v1/property/properties/update-description/(propertyId)
    @PatchMapping("/properties/update-Price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId)
    {
        propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity =new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }


    //http://localhost:8080/api/v1/property/properties/(propertyId)
    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId) {
        propertyService.deleteProperty(propertyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
