package edu.co.sena.apiclient.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class IndexController {

    @GetMapping(path = "/")
    public String saludar(){
        return "Hola chicos de adso desde Java otro cambios";
    }

}
