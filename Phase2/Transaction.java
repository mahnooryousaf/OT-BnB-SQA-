abstract public class Transaction {
    public static TransactionsFileWriter transactionsFileWriter;

    public static String rightJustify(String input, int length) {
        if (input.length() >= length)
            return input;
        int padN = length - input.length();
        StringBuilder builder = new StringBuilder(input);
        for (int i = 0; i < padN; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }

    public static String transactionTypeToCode(TransactionType transactionType) {
        String codeString = "";
        switch (transactionType) {
            case CREATE:
                codeString = "01";
                break;
            case DELETE:
                codeString = "02";
                break;
            case POST:
                codeString = "03";
                break;
            case SEARCH:
                codeString = "04";
                break;
            case RENT:
                codeString = "05";
                break;
            default:
                codeString = "00";
                break;
        };

        return codeString;
    }

    public User getUser() {
        return new User("", "");
    }

    public RentalUnit getRentalUnit() {
        return new RentalUnit("", false, getUser(), "", 0, 0, 0);
    }

    public String parseTransaction() {
        StringBuilder builder = new StringBuilder();
        TransactionType transactionType = TransactionType.CREATE;

        if (this instanceof Create) {
            transactionType = TransactionType.CREATE;
        } else if (this instanceof Logout) {
            transactionType = TransactionType.LOGOUT;
        } else if (this instanceof Rent) {
            transactionType = TransactionType.RENT;
        } else if (this instanceof Post) {
            transactionType = TransactionType.POST;
        } else if(this instanceof Delete){
            transactionType = TransactionType.DELETE;
        }
        else {
            transactionType = TransactionType.SEARCH;
        }

        double priceNum = Double.valueOf(getRentalUnit().price);
        String price = priceNum == -1? rightJustify("*", 6) : String.format("%06.02f", priceNum);

        String remainingNights =
                String.format("%02d", Integer.valueOf(getRentalUnit().remainingNights));


        Integer numBedroomsNum = Integer.valueOf(getRentalUnit().numBedrooms);
        String numBedrooms = numBedroomsNum.equals(-1)? "*": numBedroomsNum.toString();


        builder.append(transactionTypeToCode(transactionType));
        builder.append(" ");
        builder.append(rightJustify(getUser().getUsername(), 15));
        builder.append(" ");
        builder.append(rightJustify(getUser().getUserType(), 2));
        builder.append(" ");
        builder.append(rightJustify(getRentalUnit().id, 8));
        builder.append(" ");
        builder.append(rightJustify(getRentalUnit().city, 25));
        builder.append(" ");
        builder.append(numBedrooms);
        builder.append(" ");
        builder.append(price);
        builder.append(" ");
        builder.append(remainingNights);
        return builder.toString();
    }
}
