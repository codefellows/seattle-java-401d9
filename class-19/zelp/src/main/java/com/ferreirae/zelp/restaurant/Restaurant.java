package com.ferreirae.zelp.restaurant;

import com.ferreirae.zelp.review.Review;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer price;
    String name;

    @OneToMany(mappedBy = "restaurant")
    List<Review> reviews;

    @ManyToMany
    @JoinTable(name = "restaurant_likes",
        joinColumns = {@JoinColumn(name="liker")},
        inverseJoinColumns = {@JoinColumn(name="likee")}
    )
    List<Restaurant> restaurantsILike;

    @ManyToMany(mappedBy = "restaurantsILike")
    List<Restaurant> restaurantsThatLikeMe;

    @Override
    public String toString() {
        return this.name + ", price " + this.price;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public List<Restaurant> getRestaurantsILike() {
        return restaurantsILike;
    }

    public List<Restaurant> getRestaurantsThatLikeMe() {
        return restaurantsThatLikeMe;
    }

    public Long getId() {
        return this.id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
