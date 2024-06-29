package com.project.HotelBooking_BackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HotelBooking_BackEnd.model.Hotels;
import com.project.HotelBooking_BackEnd.repository.HotelRepository;

@Service
public class HotelService {
    
    @Autowired
    private HotelRepository repository;

    public void addOrUpdate(Hotels hotel) {
        repository.save(hotel);
    }

    public Iterable<Hotels> listAll() {
        return this.repository.findAll();
    }

    public void deleteHotel(String hotelId) {
        repository.deleteById(hotelId);
    }

    public Hotels getHotelById(String hotelId) {
        return repository.findById(hotelId).get();
    }  
}
