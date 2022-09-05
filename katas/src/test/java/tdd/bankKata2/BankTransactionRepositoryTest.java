package tdd.bankKata2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BankTransactionRepositoryTest {

    public static final int SOME_AMOUNT = 100;
    public static final String FIRST_DECEMBER_2021 = "01/12/2021";

    @Mock
    private BankClock bankClock;

    @Test
    void should_create_and_store_deposit_transaction() {
        BankTransactionRepository bankTransactionRepository = new BankTransactionRepository(bankClock);
        bankTransactionRepository.addDeposit(SOME_AMOUNT);

        List<BankTransaction> bankTransactionList = bankTransactionRepository.getAll();

        assertEquals(1, bankTransactionList.size());
    }

    @Test
    void should_create_and_store_withdraw_transaction() {
        BankTransactionRepository bankTransactionRepository = new BankTransactionRepository(bankClock);
        bankTransactionRepository.addWithdraw(SOME_AMOUNT);

        List<BankTransaction> bankTransactionList = bankTransactionRepository.getAll();

        assertEquals(1, bankTransactionList.size());
    }

    @Test
    void should_deposited_transaction_have_today_date_and_specified_amount() {
        BankTransactionRepository bankTransactionRepository = new BankTransactionRepository(bankClock);

        when(bankClock.todayDateAsString()).thenReturn(FIRST_DECEMBER_2021);

        bankTransactionRepository.addDeposit(SOME_AMOUNT);
        List<BankTransaction> bankTransactionList = bankTransactionRepository.getAll();

        assertEquals(transaction("01/12/2021", SOME_AMOUNT), bankTransactionList.get(0));
    }

    @Test
    void should_withdrawn_transaction_have_today_date_and_specified_amount() {
        BankTransactionRepository bankTransactionRepository = new BankTransactionRepository(bankClock);

        when(bankClock.todayDateAsString()).thenReturn(FIRST_DECEMBER_2021);

        bankTransactionRepository.addWithdraw(SOME_AMOUNT);
        List<BankTransaction> bankTransactionList = bankTransactionRepository.getAll();

        assertEquals(transaction("01/12/2021", -SOME_AMOUNT), bankTransactionList.get(0));
    }

    private BankTransaction transaction(String date, int amount) {
        return new BankTransaction(date, amount);
    }
}