package edu.co.sena.apiclient.services;

import edu.co.sena.apiclient.contracts.RolResponseDto;
import edu.co.sena.apiclient.entities.RolEntity;
import edu.co.sena.apiclient.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository repository;


    public RolEntity getRolEntity(Long id) {
        return this.repository.findById(id).get();
    }

    public List<RolResponseDto> getAllRoles() {
        List<RolResponseDto> dtos = new ArrayList<>();
        List<RolEntity> entities = repository.findAll();

        for (RolEntity r : entities) {
            RolResponseDto dto = RolResponseDto.builder()
                    .id(r.getId())
                    .title(r.getTitle())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
}
