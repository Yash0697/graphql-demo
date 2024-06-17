package com.yash.graphql_demo.service;

import com.yash.graphql_demo.entity.Venue;

import java.util.List;

public interface VenueService {

    List<Venue> getAllVenues();
    List<Venue> getVenuesWithRatingsGreaterThan(Double rating);

    Venue getVenue(Integer id);

    Venue rateVenue(Integer venueId, double rating);
}
