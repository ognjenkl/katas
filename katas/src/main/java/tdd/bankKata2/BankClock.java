package tdd.bankKata2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankClock {

    public static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String todayDateAsString() {
        return today().format(DD_MM_YYYY);
    }

    protected LocalDate today() {
        return LocalDate.now();
    }

}
