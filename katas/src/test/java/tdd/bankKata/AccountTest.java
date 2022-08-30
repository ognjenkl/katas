package tdd.bankKata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class AccountTest {

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private StatementPrinter statementPrinter;

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    void shouldStoreDepositTransactionTest() {
        account.deposit(100);

        verify(transactionRepository).addDeposit(100);
    }

    @Test
    void shouldStoreWithdrawTransactionTest() {
        account.withdraw(100);

        verify(transactionRepository).addWithdraw(100);
    }
}