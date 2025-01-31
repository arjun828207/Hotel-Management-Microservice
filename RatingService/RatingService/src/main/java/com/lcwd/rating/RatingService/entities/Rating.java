package com.lcwd.rating.RatingService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ratings")
public class Rating {

    @Id
    public String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String feedback;

}
