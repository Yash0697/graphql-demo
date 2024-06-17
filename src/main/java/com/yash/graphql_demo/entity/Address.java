package com.yash.graphql_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(generator = "string-id-generator")
    @GenericGenerator(name = "string-id-generator", strategy = "com.yash.graphql_demo.generator.StringIdGenerator")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String state;
    private String city;
    private String zipCode;
    private String country;
    @OneToMany(mappedBy = "address")
    private List<Venue> venues;

    public Address(String state, String city, String zipCode, String country) {
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }
}
