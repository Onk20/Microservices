package com.lcwd.rating.RatingService.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings")
public class Rating {


    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
