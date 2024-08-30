package com.happyTravel.happyTravel.models;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String country;
    @Column(length = 500)
    private String message;
    private String image;
    private int id_user;


    public Destination(){}

    public Destination setId_user(int id_user) {
        this.id_user = id_user;
        return this;
    }

    public Destination setImage(String image) {
        this.image = image;
        return this;
    }

    public Destination setMessage(String message) {
        this.message = message;
        return this;
    }

    public Destination setCountry(String country) {
        this.country = country;
        return this;
    }

    public Destination setName(String name) {
        this.name = name;
        return this;
    }

    public Destination setId(int id) {
        this.id = id;
        return this;
    }
}
