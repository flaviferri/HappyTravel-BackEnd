package com.happyTravel.happyTravel.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DestinationTest {

    @Test
    void testDestinationSettersAndGetters() {
        Destination destination = new Destination();
        destination.setId(1);
        destination.setName("Paris");
        destination.setCountry("France");
        destination.setMessage("A beautiful city");
        destination.setImage("paris.jpg");
        destination.setId_user(1);

        assertEquals(1, destination.getId());
        assertEquals("Paris", destination.getName());
        assertEquals("France", destination.getCountry());
        assertEquals("A beautiful city", destination.getMessage());
        assertEquals("paris.jpg", destination.getImage());
        assertEquals(1, destination.getId_user());
    }
}