package edu.co.sena.apiclient.controllers;

import edu.co.sena.apiclient.contracts.UserRequestCreateDto;
import edu.co.sena.apiclient.contracts.UserResponseDetailDto;
import edu.co.sena.apiclient.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping()
    public String create(@RequestBody UserRequestCreateDto request) {
        this.service.create(request);
        return "ok";
    }

    @GetMapping
    public List<UserResponseDetailDto> getAll(){
        return this.service.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public UserResponseDetailDto getById(
            @PathVariable("id") Long id
            ){

        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody UserRequestCreateDto request){
        this.service.update(request, id);
        return "ok";
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id){
        this.service.delete(id);
        return "ok";
    }

}
