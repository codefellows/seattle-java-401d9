package com.ferreirae.zelp.review;

import com.ferreirae.zelp.restaurant.Restaurant;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition="text")
    String body;

    @ManyToOne
    Restaurant restaurant;

    public String toString() {
        return this.body;
    }
}
