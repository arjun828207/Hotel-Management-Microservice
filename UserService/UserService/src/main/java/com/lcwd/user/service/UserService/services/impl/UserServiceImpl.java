package com.lcwd.user.service.UserService.services.impl;

import com.lcwd.user.service.UserService.entities.Rating.Rating;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.exception.ResourceNotFoundException;
import com.lcwd.user.service.UserService.respositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserServices;
import com.lcwd.user.service.controllers.UserController;
import com.lcwd.user.service.external.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public User saveUser(User user) {

        String randUserId = UUID.randomUUID().toString();
        user.setUserId(randUserId);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        User user  = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found on server"));

        //fetch rating of the user from rating service
        //http://localhost:8071/ratings/users/284c0bdf-e0ae-4f2b-86a4-6248bad9638c
        // RestTemplate
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);

        logger.info("{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList =  ratings.stream().map(rating ->{

            Hotel hotel = hotelService.getHotel(rating.getHotelId());

           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(),Hotel.class);
            //Hotel hotel = forEntity.getBody();
            rating.setHotel(hotel);
            //logger.info("response status code {}",forEntity.getStatusCode());
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String userId, User user) {
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
        userRepository.delete(user);

        return true;
    }
}
