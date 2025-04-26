package com.lcwd.user.service.controller;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.flogger.Flogger;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    private Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);



    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    int retryCount = 1;
    // Get single user
    @GetMapping("users/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserWithUserId(@PathVariable  String userId){

        System.out.println("Retry count : "+retryCount);
        retryCount++;
        User user = userService.getUserWithUserId(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // Creating fallback method for circuitbreaker

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){

//        logger.info("Fallback isn executed because service is down : ", ex.getMessage());

        User user = User.builder().email("dummy@gmail.com")
                .name("Dummy")
                .about("This is user is created dummy bcz some services is down")
                .userId("141234").build();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){

        List<User> allUsers = userService.getAllUser();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
