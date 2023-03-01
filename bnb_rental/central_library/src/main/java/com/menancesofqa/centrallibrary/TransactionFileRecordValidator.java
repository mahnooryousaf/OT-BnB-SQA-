package com.menancesofqa.centrallibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionFileRecordValidator {
    int usernameLength;
    int userTypeLength;
    int rentalIdLength;
    int cityLength;
    int bedroomsLength;
    int nightsLength;
    int rentalPriceLength;

    String isRecordValid(String record){
        throw new UnsupportedOperationException();
    }

    String isUsernameFieldValid(String usernameField){
        throw new UnsupportedOperationException();
    }

    String isRentalIdFieldValid(String rentalIdField){
        throw new UnsupportedOperationException();
    }

    String isCityFieldValid(String cityField){
        throw new UnsupportedOperationException();
    }

    String isBedroomsFieldValid(String bedroomsField){
        throw new UnsupportedOperationException();
    }

    String isNightsFieldValid(String nightsField){
        throw new UnsupportedOperationException();
    }

    String isRentalPriceFieldValid(String rentalPriceField){
        throw new UnsupportedOperationException();
    }

}
