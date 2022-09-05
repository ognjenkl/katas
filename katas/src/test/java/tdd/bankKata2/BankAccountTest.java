package tdd.bankKata2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BankAccountTest {

    public static final int SOME_AMOUNT = 100;
    @Mock
    private BankTransactionRepository bankTransactionRepository;
    @Mock
    private BankStatementPrinter bankStatementPrinter;

    BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(bankTransactionRepository, bankStatementPrinter);
    }

    @Test
    void should_store_deposit_transaction() {
        account.deposit(SOME_AMOUNT);

        verify(bankTransactionRepository).addDeposit(SOME_AMOUNT);
    }

    @Test
    void should_store_withdraw_transaction() {
        account.withdraw(SOME_AMOUNT);

        verify(bankTransactionRepository).addWithdraw(SOME_AMOUNT);
    }

    @Test
    void should_print_statement() {
        List<BankTransaction> transactionList = List.of(new BankTransaction("01/12/2021", SOME_AMOUNT));
        when(bankTransactionRepository.getAll()).thenReturn(transactionList);

        account.printStatement();

        verify(bankStatementPrinter).print(transactionList);
    }

}