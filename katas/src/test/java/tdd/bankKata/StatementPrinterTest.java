package tdd.bankKata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class StatementPrinterTest {

    private static final List<Transaction> NO_TRANSACTIONS = Collections.emptyList();
    @Mock
    private Console console;

    private StatementPrinter statementPrinter;

    @BeforeEach
    void setUp() {
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    void should_print_header_statement_line() {
        statementPrinter.print(NO_TRANSACTIONS);

        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    void should_print_transactions_in_reverse_chronological_order() {

        Transaction deposit1 = new Transaction("01/04/2014", 1000);
        Transaction withdraw = new Transaction("02/04/2014", -100);
        Transaction deposit2 = new Transaction("10/04/2014", 500);
        List<Transaction> transactionList = List.of(deposit1, withdraw, deposit2);

        statementPrinter.print(transactionList);

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}