package com.yash.graphql_demo;

import com.yash.graphql_demo.entity.Address;
import com.yash.graphql_demo.entity.Venue;
import com.yash.graphql_demo.repository.AddressRepository;
import com.yash.graphql_demo.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.Arrays;

@SpringBootApplication
public class GraphqlDemoApplication {

	@Autowired
	private VenueRepository venueRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApplication.class, args);
	}

	@EventListener(ApplicationStartedEvent.class)
	public void onApplicationStarted() {
		Address address = new Address("Maharashtra", "Mumbai", "400001", "India");
		Address address1 = new Address("Karnataka", "Bangalore", "530068", "India");
		Address address2 = new Address("New Jersey", "New York", "10008", "USA");
		Address address3 = new Address("Ohio", "Cincinnati", "45201", "USA");
		Address address4 = new Address("Messina", "Rome", "98168", "Italy");
//		addressRepository.saveAll(Arrays.asList(address, address1, address2, address3, address4));

		Venue venue = new Venue("JW Marriott Mumbai Sahar Airport",
				"Offering an outdoor swimming pool, fitness centre and a spa wellness centre",
				address,
				"09345678986",
				"mum@marriot.com",
				"985489096");
		venue.setRating(4.8);
		Venue venue1 = new Venue("Taj MG Road Bengaluru",
				"Central location and all the good facilities in the room",
				address1,
				"07635686743",
				"ban@obgc.com",
				"0865459");
		venue1.setRating(4.2);
		Venue venue2 = new Venue("Hyatt Place New York City",
				"Air-conditioned rooms with satellite flat-screen TV",
				address2,
				"555‑0100",
				"nyus@hyatt.com",
				"56789009");
		venue2.setRating(4.0);
		Venue venue3 = new Venue("Holiday Inn Hotel & Suites",
				"Holiday Inn Hotel & Suites Cincinnati Downtown, an IHG Hotel offers 3-star accommodation in Cincinnati and has a fitness centre, a restaurant and a bar",
				address3,
				"555‑1231",
				"ohcin@holiInn.com",
				"0584732789");
		venue3.setRating(4.5);
		Venue venue4 = new Venue("Madison Hotel",
				"Madison Hotel is directly opposite Rome Termini Station for metro and bus services across the city.",
				address4,
				"39287861027",
				"mess@madison.com",
				"9756486897");
		venue4.setRating(4.3);
		Venue venue5 = new Venue("Guest House",
				"Test Guest House",
				address1,
				"9876543212",
				"callmea@test.com",
				"975684");
		venue4.setRating(3.9);
		venueRepository.saveAll(Arrays.asList(venue, venue1, venue2, venue3, venue4, venue5));

	}
}

