package com.example.property_management.Converter;

import com.example.property_management.dto.PropertyDTO;
import com.example.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity (PropertyDTO propertyDTO)
    {
        PropertyEntity pe =new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());
        return pe;
    }
    public PropertyDTO convertEntitytoDTO (PropertyEntity propertyEntity)
    {
        PropertyDTO pd =new PropertyDTO();
        pd.setTitle(propertyEntity.getTitle());
        pd.setAddress(propertyEntity.getAddress());
        pd.setOwnerName(propertyEntity.getOwnerName());
        pd.setOwnerEmail(propertyEntity.getOwnerEmail());
        pd.setDescription(propertyEntity.getDescription());
        pd.setPrice(propertyEntity.getPrice());
        return pd;
    }


}
