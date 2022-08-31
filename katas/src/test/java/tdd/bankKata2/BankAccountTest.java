package tdd.bankKata2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class BankAccountTest {

    @Mock
    private BankTransactionRepository bankTransactionRepository;

    @Test
    void should_store_deposit_transaction() {
        BankAccount account = new BankAccount(bankTransactionRepository);

        account.deposit(100);

        verify(bankTransactionRepository).addDeposit(100);
    }

    @Test
    void should_store_withdraw_transaction() {
        BankAccount account = new BankAccount(bankTransactionRepository);

        account.withdraw(100);

        verify(bankTransactionRepository).addWithdraw(100);
    }

}