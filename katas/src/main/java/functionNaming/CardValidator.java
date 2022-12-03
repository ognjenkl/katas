package functionNaming;

import lombok.Data;

import java.time.LocalDate;

public class CardValidator {

    boolean validateCard(String number, int expirationMonth, int expirationYear) {
        return isChecksumValid(number)
                && isMonthYearValid(expirationMonth, expirationYear);
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
        customer.setNumber("1249190007575069");
        customer.setExpMonth(1);
        customer.setExpYear(2024);

        customer.setValid(cardValidator.validateCard(
                customer.getNumber(), customer.getExpMonth(), customer.getExpYear()));
        System.out.println("Is Alice's card valid?");
        System.out.println(customer.isValid());
        System.out.println(customer);
    }

    @Data
    static class Customer {
        String name;
        String phone;
        String number;
        Integer expMonth;
        Integer expYear;
        boolean valid = false;
    }
}
