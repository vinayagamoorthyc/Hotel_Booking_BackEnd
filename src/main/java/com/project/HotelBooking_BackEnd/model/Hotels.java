package com.project.HotelBooking_BackEnd.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotels {
    @Id
    private String hotelId;
    private String name;
    private Number price;
    private String address;
    private Number contact;
    private String desc;
    private String imgurl;
    private String category;
}
