package com.lcwd.user.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

   @Autowired
   private RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
    void createRating(){

		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using Feign Client").build();
		Rating savedRating = ratingService.createRating(rating);

		System.out.println("new rating created");
	}

}
