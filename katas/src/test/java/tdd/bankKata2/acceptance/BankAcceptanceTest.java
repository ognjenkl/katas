package tdd.bankKata2.acceptance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tdd.bankKata2.*;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BankAcceptanceTest {

    @Mock
    private BankClock bankClock;
    @Mock
    private BankConsole bankConsole;

    @Test
    void shouldPrintStatementsContainingAllTransactions() {
        BankTransactionRepository bankTransactionRepository = new BankTransactionRepository(bankClock);
        when(bankClock.todayDateAsString()).thenReturn("01/04/2014", "02/04/2014", "10/04/2014");

        BankStatementPrinter statementPrinter = new BankStatementPrinter(bankConsole);
        BankAccount account = new BankAccount(bankTransactionRepository, statementPrinter);

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(bankConsole);
        inOrder.verify(bankConsole).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(bankConsole).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(bankConsole).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(bankConsole).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
