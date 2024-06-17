package com.yash.graphql_demo.repository;

import com.yash.graphql_demo.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer> {
    @Query(value = "Select * from Venue where rating > :rating", nativeQuery = true)
    List<Venue> findVenuesWithRatingsGreaterThan(Double rating);
}
