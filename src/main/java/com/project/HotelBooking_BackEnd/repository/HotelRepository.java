package com.project.HotelBooking_BackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.HotelBooking_BackEnd.model.Hotels;

public interface HotelRepository extends MongoRepository<Hotels, String>{
    
}
