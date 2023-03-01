package com.menancesofqa.centrallibrary;

import lombok.Data;

@Data
public class RentalUnit {
    String id;
    boolean rented;
    String username;
    String city;
    int numberOfBedrooms;
    int remainingNights;
    double price;
}
