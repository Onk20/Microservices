package com.lcwd.hotel.HotelService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StaffController {

    @GetMapping("/staffs/getstaff")
    public ResponseEntity<List<String>> getStaff(){
        List<String> list = Arrays.asList("Ram", "Shyam", "Sita", "Gita");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
