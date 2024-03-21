package edu.co.sena.apiclient.controllers;

import edu.co.sena.apiclient.contracts.TypeZoneDto;
import edu.co.sena.apiclient.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/zone")
public class ZonesController {

    @Autowired
    private ZoneService service;

    @GetMapping(path = "")
    public List<TypeZoneDto> getZones(){
        return this.service.getZones();
    }
}
