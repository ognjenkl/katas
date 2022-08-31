package tdd.bankKata2.acceptance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tdd.bankKata2.BankAccount;
import tdd.bankKata2.BankTransactionRepository;
import tdd.bankKata2.BankConsole;

@ExtendWith(SpringExtension.class)
public class BankAcceptanceTest {

    @Mock
    private BankConsole console;

    @Test
    void shouldPrintStatementsContainingAllTransactions() {
        BankTransactionRepository bankTransactionRepository = new BankTransactionRepository();
        BankAccount account = new BankAccount(bankTransactionRepository);
        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
