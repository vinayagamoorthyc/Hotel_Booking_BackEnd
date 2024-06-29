package com.project.HotelBooking_BackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HotelBooking_BackEnd.model.Users;
import com.project.HotelBooking_BackEnd.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public void addOrUpdate(Users user) {
        repository.save(user);
    }

    public Iterable<Users> listAll() {
        return this.repository.findAll();
    }

    public Users findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
