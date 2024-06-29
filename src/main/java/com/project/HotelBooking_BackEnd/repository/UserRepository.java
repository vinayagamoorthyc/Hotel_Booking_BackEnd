package com.project.HotelBooking_BackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.HotelBooking_BackEnd.model.Users;

public interface UserRepository extends MongoRepository<Users, String>{
    Users findByEmail(String email);
}
