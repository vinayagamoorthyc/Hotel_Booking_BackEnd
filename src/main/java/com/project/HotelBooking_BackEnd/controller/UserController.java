package com.project.HotelBooking_BackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.HotelBooking_BackEnd.model.Users;
import com.project.HotelBooking_BackEnd.service.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Users")
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping(value = "/create")
    public String createUser(@RequestBody Users user){
        service.addOrUpdate(user);
        return user.getUserId();
    }

    @GetMapping(value = "/getAll")
    public Iterable<Users> getUsers(){
        return service.listAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users req) {
        Users user = service.findByEmail(req.getEmail());
        if (user != null && user.getPassword().equals(req.getPassword())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
