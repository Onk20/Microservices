package com.lcwd.rating.RatingService.services;


import com.lcwd.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getAllRatingsByUserId(String userId);

    List<Rating> getAllRatingsByHotel(String hotelId);

    List<Rating> getAllRatings();
}
