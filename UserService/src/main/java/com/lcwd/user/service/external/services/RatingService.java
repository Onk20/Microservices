package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Rating;
import lombok.Builder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "RATINGSERVICE")

public interface RatingService {

    @PostMapping("/ratings")
    public Rating createRating(@RequestBody Rating values);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating( @PathVariable  String ratingId, @RequestBody Rating values);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
