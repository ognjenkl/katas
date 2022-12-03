package functionNaming;

import lombok.Data;

import java.time.LocalDate;

public class CardValidator {

    boolean validateCard(Customer customer) {
        customer.setValid(isChecksumValid(customer) && isMonthYearValid(customer));
        return customer.isValid();
    }

    boolean isMonthYearValid(Customer customer) {
        boolean monthYearValid = LocalDate.of(
                customer.getExpYear(), customer.getExpMonth(), 1).isAfter(LocalDate.now());
        return monthYearValid;
    }

    boolean isChecksumValid(Customer customer) {
        Integer checksum = 0;
        for (int i = 0; i < customer.getNumber().length(); i++) {
            Integer digit = Integer.parseInt(customer.getNumber().substring(i, i + 1));
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

        boolean isValid = cardValidator.validateCard(customer);
        System.out.println("Is Alice's card valid?");
        System.out.println(isValid);
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
