package com.lcwd.rating.RatingService.service;

import com.lcwd.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    Rating updateRating(String ratingId, Rating rating);
    
    List<Rating> getRatingsByUserId(String userId);

    List<Rating> getRatingsByHotelId(String hotelId);

    void deleteRating(String ratingId);

    Rating getRatingById(String ratingId);

    List<Rating> getRatings();

}
