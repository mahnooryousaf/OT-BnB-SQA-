package com.menancesofqa.centrallibrary;

import lombok.Data;
import lombok.Getter;

@Data
abstract public class Transaction {
    @Getter
    private TransactionType transactionType;
    User user;

    abstract String parseTransaction();

    /**
     * Convert transaction type to corresponding code
     * @return Numerical code
     */
    String transactionTypeToCode(){
        String code = switch (transactionType){
            case Post -> "03";
            case Rent -> "05";
            case Create -> "01";
            case Search -> "04";
            case Delete -> "02";
            case Logout -> "00";
        };

        return code;
    }
}
