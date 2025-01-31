package com.lcwd.rating.RatingService.service;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    public RatingRepository repository;

    @Override
    public Rating createRating(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public Rating updateRating(String ratingId, Rating rating) {
        return null;
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }

    @Override
    public void deleteRating(String ratingId) {

        repository.deleteById(ratingId);

    }

    @Override
    public Rating getRatingById(String ratingId) {
        return repository.findById(ratingId).orElseThrow();
    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }
}
