package com.yash.graphql_demo.controller;

import com.yash.graphql_demo.entity.Venue;
import com.yash.graphql_demo.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VenueController {

    // method name must match the query name in schema
    @Autowired
    private VenueService venueService;

    @QueryMapping
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }
    @QueryMapping
    public Venue getVenue(@Argument Integer id) {
        return venueService.getVenue(id);
    }

    @QueryMapping
    public List<Venue> getVenuesByGreaterRating(@Argument Double rating) {
        return venueService.getVenuesWithRatingsGreaterThan(rating);
    }
    @MutationMapping
    public Venue rateVenue(@Argument double rating, @Argument Integer venueId) {
        return venueService.rateVenue(venueId, rating);
    }
}
