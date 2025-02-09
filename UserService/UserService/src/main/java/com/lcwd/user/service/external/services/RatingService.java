package com.lcwd.user.service.external.services;

import com.lcwd.user.service.UserService.entities.Rating.Rating;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    //get

    //post

    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    //put
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId} ")
    public void deleteRating(@PathVariable String ratingId  );




}
