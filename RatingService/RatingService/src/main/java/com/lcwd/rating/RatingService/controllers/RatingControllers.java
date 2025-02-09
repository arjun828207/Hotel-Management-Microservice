package com.lcwd.rating.RatingService.controllers;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ratings")
public class RatingControllers {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ResponseEntity.ok(ratingService.createRating(rating));
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, @RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.updateRating(ratingId, rating));
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable String ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId) {
        return ResponseEntity.ok(ratingService.getRatingById(ratingId));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.ok(ratingService.getRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }
}
