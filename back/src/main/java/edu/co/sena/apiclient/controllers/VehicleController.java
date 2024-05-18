package edu.co.sena.apiclient.controllers;

import edu.co.sena.apiclient.contracts.UserResponseDetailDto;
import edu.co.sena.apiclient.contracts.VehicleResponseDto;
import edu.co.sena.apiclient.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping(path = "/plate/{plate}")
    public VehicleResponseDto getByPlate(
            @PathVariable("plate") String plate
    ){
        return this.service.getByPlate(plate);
    }

}
