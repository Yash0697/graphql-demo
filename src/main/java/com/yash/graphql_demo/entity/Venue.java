package com.yash.graphql_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    private String phone;
    private String email;
    private String managerId;
    private Double rating;
    private Long bookingCount = 1L;

    public Venue(String name, String description, Address address, String phone, String email, String managerId) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.managerId = managerId;
    }
}
