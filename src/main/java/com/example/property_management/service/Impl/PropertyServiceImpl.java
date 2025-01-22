package com.example.property_management.service.Impl;

import com.example.property_management.Converter.PropertyConverter;
import com.example.property_management.Repository.PropertyRepository;
import com.example.property_management.dto.PropertyDTO;
import com.example.property_management.entity.PropertyEntity;
import com.example.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;  // Use the injected PropertyConverter

    @Override
    public PropertyDTO saveproperty(PropertyDTO propertyDTO) {
        // Use the propertyConverter instance to call the convertDTOtoEntity method
        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);

        // Save the converted entity
        propertyRepository.save(pe);
        propertyDTO =propertyConverter.convertEntitytoDTO(pe);

        return propertyDTO;  // You can return the DTO or any other response as needed
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps=(List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList=new ArrayList<>();

        for(PropertyEntity pe:listOfProps)
        {
           PropertyDTO dto= propertyConverter.convertEntitytoDTO(pe);
           propList.add(dto);
        }
        // Return the populated list
        return propList;
    }
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId)
    {
        Optional<PropertyEntity>opEnt=propertyRepository.findById(propertyId);
        PropertyDTO dto =null;
        if (opEnt.isPresent())
        {
            PropertyEntity pe =opEnt.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);

        }
        return dto;
    }


    @Override
     public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId)
        {
            Optional<PropertyEntity>opEnt=propertyRepository.findById(propertyId);
            PropertyDTO dto =null;
            if (opEnt.isPresent())
            {
                PropertyEntity pe =opEnt.get();
                pe.setDescription(propertyDTO.getDescription());
                dto = propertyConverter.convertEntitytoDTO(pe);
                propertyRepository.save(pe);

            }
            return dto;
        }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId)
            {
                Optional<PropertyEntity>opEnt=propertyRepository.findById(propertyId);
                PropertyDTO dto =null;
                if (opEnt.isPresent())
                {
                    PropertyEntity pe =opEnt.get();
                    pe.setPrice(propertyDTO.getPrice());
                    dto = propertyConverter.convertEntitytoDTO(pe);
                    propertyRepository.save(pe);
                }
                return dto;
            }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

}
