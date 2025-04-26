package com.lcwd.user.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {



    private  String hotelId;
    private String name;
    private String location;
    private  String about;
}