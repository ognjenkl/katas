package functionNaming;

import lombok.Data;

import java.time.LocalDate;

public class CardValidator {

    boolean validateCard(Card card) {
        return isChecksumValid(card.getNumber())
                && isMonthYearValid(card.getExpMonth(), card.getExpYear());
    }

    boolean isMonthYearValid(int expirationMonth, int expiryYear) {
        boolean monthYearValid = LocalDate.of(
                expiryYear, expirationMonth, 1).isAfter(LocalDate.now());
        return monthYearValid;
    }

    boolean isChecksumValid(String number) {
        Integer checksum = 0;
        for (int i = 0; i < number.length(); i++) {
            Integer digit = Integer.parseInt(number.substring(i, i + 1));
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            checksum += digit;
        }
        return checksum % 10 == 0;
    }

    public static void main(String[] args) {
        CardValidator cardValidator = new CardValidator();
        Customer customer = new Customer();
        customer.setName("Alice");
        customer.setPhone("2341");
        Card card = new Card();
        card.setNumber("1249190007575069");
        card.setExpMonth(1);
        card.setExpYear(2024);

        customer.setValid(cardValidator.validateCard(card));
        System.out.println("Is Alice's card valid?");
        System.out.println(customer.isValid());
        System.out.println(customer);
    }

    @Data
    static class Customer {
        String name;
        String phone;
        Card card;
        boolean valid = false;
    }

    @Data
    static class Card {
        String number;
        Integer expMonth;
        Integer expYear;
    }
}
