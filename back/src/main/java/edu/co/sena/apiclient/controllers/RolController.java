package edu.co.sena.apiclient.controllers;

import edu.co.sena.apiclient.contracts.RolResponseDto;
import edu.co.sena.apiclient.contracts.UserResponseDetailDto;
import edu.co.sena.apiclient.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<RolResponseDto> getAll() {
        return rolService.getAllRoles();
    }

}
