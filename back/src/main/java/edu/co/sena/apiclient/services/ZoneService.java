package edu.co.sena.apiclient.services;

import edu.co.sena.apiclient.contracts.TypeZoneDto;
import edu.co.sena.apiclient.contracts.ZoneDto;
import edu.co.sena.apiclient.entities.ZoneEntity;
import edu.co.sena.apiclient.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository repository;

    public List<TypeZoneDto> getZones() {
        HashMap<String, TypeZoneDto> map = new HashMap<>();
        List<ZoneEntity> zones = this.repository.findAll();
        for (ZoneEntity zone: zones) {
            String key = zone.getReferenceType().getTitle();
            TypeZoneDto typeZoneDto = map.get(key);

            if(typeZoneDto == null) {
                typeZoneDto = TypeZoneDto.builder()
                        .title(key)
                        .zones(new ArrayList<>())
                        .build();
                map.put(key, typeZoneDto);
            }

            typeZoneDto.getZones().add(ZoneDto.builder()
                            .id(zone.getId())
                            .title(zone.getTitle())
                            .status(zone.getStatus())
                    .build());
        }

        return new ArrayList<>(map.values());
    }

}
