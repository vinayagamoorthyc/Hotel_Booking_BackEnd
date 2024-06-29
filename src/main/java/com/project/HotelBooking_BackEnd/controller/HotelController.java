package com.project.HotelBooking_BackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.HotelBooking_BackEnd.model.Hotels;
import com.project.HotelBooking_BackEnd.service.HotelService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/Hotels")
public class HotelController {
    
    @Autowired
    private HotelService service;

    @PostMapping(value = "/create")
    public String createHotel(@RequestBody Hotels hotel){
        service.addOrUpdate(hotel);
        return hotel.getHotelId();
    }

    @GetMapping(value = "/getAll")
    public Iterable<Hotels> getHotels(){
        return service.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    public Hotels update(@RequestBody Hotels hotelup,@PathVariable (name="id")String hotelId){
        hotelup.setHotelId(hotelId);
        service.addOrUpdate(hotelup);
        return hotelup;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHotels(@PathVariable("id") String hotelId){
        service.deleteHotel(hotelId);
    }

    @RequestMapping("/search/{id}")
    private Hotels getHotel(@PathVariable("id") String hotelId){
        return service.getHotelById(hotelId);
    }
}
