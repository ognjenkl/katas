package tdd.bankKata2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BankClockTest {

    public static final String TODAY = "01/12/2021";

    @Test
    void should_return_today_date_properly_formatted() {
        BankClock bankClock = new TestableBankClock();

        String today = bankClock.todayDateAsString();

        assertEquals(TODAY, today);
    }

    private class TestableBankClock extends BankClock {
        @Override
        protected LocalDate today() {
            return LocalDate.of(2021, 12, 1);
        }
    }
}