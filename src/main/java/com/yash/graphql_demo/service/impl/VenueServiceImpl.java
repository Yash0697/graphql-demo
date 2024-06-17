package com.yash.graphql_demo.service.impl;

import com.yash.graphql_demo.entity.Venue;
import com.yash.graphql_demo.exception.VenueNotFoundException;
import com.yash.graphql_demo.repository.VenueRepository;
import com.yash.graphql_demo.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    @Override
    public List<Venue> getVenuesWithRatingsGreaterThan(Double rating) {
        return venueRepository.findVenuesWithRatingsGreaterThan(rating);
    }

    @Override
    public Venue getVenue(Integer id) {
        return Objects.requireNonNull(venueRepository.findById(id).orElse(null));
    }

    @Override
    public Venue rateVenue(Integer venueId, double rating) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new VenueNotFoundException("Venue with id "+venueId+" not found"));
        Double currentRating = venue.getRating();
        Long currentBookings = venue.getBookingCount();
        Double updatedRating = (currentRating * currentBookings + rating) / (1 + currentBookings);
        venue.setRating(updatedRating);
        venue.setBookingCount(1 + currentBookings);
        return venueRepository.save(venue);
    }
}
