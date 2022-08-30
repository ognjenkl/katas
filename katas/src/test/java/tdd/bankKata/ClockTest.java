package tdd.bankKata;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockTest {

    @Test
    void should_return_date_as_string_dd_mm_yyyy() {
        Clock clock = new TestableClock();

        String date = clock.todayDateAsString();

        assertEquals("01/12/2021", date);
    }


    private class TestableClock extends Clock {
        @Override
        protected LocalDate getTodayDate() {
            return LocalDate.of(2021, 12, 1);
        }
    }
}
