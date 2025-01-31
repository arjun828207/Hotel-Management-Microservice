package com.lcwd.user.service.UserService.entities;

import com.lcwd.user.service.UserService.entities.Rating.Rating;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME",length = 20)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

    @Column(name = "PHNO")
    private String phno;

    @Transient
    private List<Rating> ratings;
}
