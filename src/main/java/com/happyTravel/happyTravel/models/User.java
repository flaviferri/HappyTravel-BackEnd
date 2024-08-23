package com.happyTravel.happyTravel.models;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name="users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String name;
        private String email;
        private String password;



        public User (){}
}
