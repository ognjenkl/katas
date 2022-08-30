package tdd.bankKata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    public String todayDateAsString() {
        LocalDate today = getTodayDate();
        return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    protected LocalDate getTodayDate() {
        return LocalDate.now();
    }
}
