package com.happyTravel.happyTravel.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;

class AuthResponseTest {

    @Test
    void testConstructorAndGetters() {

        String token = "dummyToken";
        UserDetails userDetails = Mockito.mock(UserDetails.class);

        AuthResponse authResponse = new AuthResponse(token, userDetails);

        assertThat(authResponse.getToken()).isEqualTo(token);
        assertThat(authResponse.getUser()).isEqualTo(userDetails);
    }

    @Test
    void testSetters() {

        AuthResponse authResponse = new AuthResponse();

        String token = "dummyToken";
        UserDetails userDetails = Mockito.mock(UserDetails.class);

        authResponse.setToken(token);
        authResponse.setUser(userDetails);

        assertThat(authResponse.getToken()).isEqualTo(token);
        assertThat(authResponse.getUser()).isEqualTo(userDetails);
    }

    @Test
    void testBuilder() {

        String token = "dummyToken";
        UserDetails userDetails = Mockito.mock(UserDetails.class);

        AuthResponse authResponse = AuthResponse.builder()
                .token(token)
                .user(userDetails)
                .build();

        assertThat(authResponse.getToken()).isEqualTo(token);
        assertThat(authResponse.getUser()).isEqualTo(userDetails);
    }

    @Test
    void testEqualsAndHashCode() {

        String token = "dummyToken";
        UserDetails userDetails = Mockito.mock(UserDetails.class);

        AuthResponse authResponse1 = new AuthResponse(token, userDetails);
        AuthResponse authResponse2 = new AuthResponse(token, userDetails);

        assertThat(authResponse1).isEqualTo(authResponse2);
        assertThat(authResponse1.hashCode()).isEqualTo(authResponse2.hashCode());
    }

    @Test
    void testToString() {

        String token = "dummyToken";
        UserDetails userDetails = Mockito.mock(UserDetails.class);

        AuthResponse authResponse = new AuthResponse(token, userDetails);

        String result = authResponse.toString();

        assertThat(result).contains("dummyToken");
        assertThat(result).contains(userDetails.toString());
    }
}