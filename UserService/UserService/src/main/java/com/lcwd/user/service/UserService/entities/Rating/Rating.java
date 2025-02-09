package com.lcwd.user.service.UserService.entities.Rating;

import com.lcwd.user.service.UserService.entities.Hotel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    public String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;

}
