package tdd.bankKata.acceptance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tdd.bankKata.*;

/*
    Create simple bank application with the following features:
        - Deposit into Account
        - Withdraw from an Account
        - Print a bank statement to the console

    Acceptance criteria
    Statement should have transactions in the following format:

        DATE        |   AMOUNT  |   BALANCE
        10/04/2014  |   500.00  |   1400.00
        02/04/2014  |   -100.00 |   900.00
        01/04/2014  |   1000.00 |   1000.00

    Starting point and constraints
    1. Start with a class the following structure:
        public class Account {
            public void deposit(int amount);
            public void withdraw(int amount);
            public void printStatement();
        }

    2. You are not allowed to add any other public method to this class
    3. Use Strings and Integers for dates and amounts (keep it simple)
    4. Don't worry about spacing in the statement printed on the console
 */
@ExtendWith(SpringExtension.class)
public class BankAcceptanceTest {

    @Mock
    private Console console;

    @Test
    void shourdPrintStatemenContainingAllTransactions() {
        TransactionRepository transactionRepository = new TransactionRepository();
        StatementPrinter statementPrinter = new StatementPrinter();
        Account account = new Account(transactionRepository, statementPrinter);
        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printStatementLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printStatementLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printStatementLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printStatementLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
