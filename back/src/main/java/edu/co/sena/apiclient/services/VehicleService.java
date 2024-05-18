package edu.co.sena.apiclient.services;

import edu.co.sena.apiclient.contracts.UserResponseDetailDto;
import edu.co.sena.apiclient.contracts.VehicleResponseDto;
import edu.co.sena.apiclient.entities.UserEntity;
import edu.co.sena.apiclient.entities.VehicleEntity;
import edu.co.sena.apiclient.exceptions.ResourceNotFoundException;
import edu.co.sena.apiclient.repositories.VehicleRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public VehicleResponseDto getByPlate(String plate) {
        VehicleEntity entity = this.repository.getByPlate(plate);

        if (Objects.isNull(entity)) {
            throw new ResourceNotFoundException();
        }

        VehicleResponseDto dto = new VehicleResponseDto();
        dto.setId(entity.getId());
        dto.setPlate(entity.getPlate());
        dto.setColor(entity.getColor());
        dto.setBrand(entity.getBrand());
        dto.setDescription(entity.getDescription());
        dto.setType(entity.getReferenceType().getTitle());

        return dto;
    }

}
