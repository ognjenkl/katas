package tdd.bankKata2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class BankStatementPrinterTest {

    @Mock
    BankConsole bankConsole;

    @Test
    void should_print_header() {
        BankStatementPrinter bankStatementPrinter = new BankStatementPrinter(bankConsole);
        List<BankTransaction> transactionList = Collections.emptyList();
        bankStatementPrinter.print(transactionList);

        verify(bankConsole).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    void should_print_transactions_format_two_decimals() {
        BankStatementPrinter bankStatementPrinter = new BankStatementPrinter(bankConsole);
        List<BankTransaction> transactionList = new ArrayList<>();
        transactionList.add(new BankTransaction("01/12/2021", 100));
        transactionList.add(new BankTransaction("02/12/2021", -100));
        transactionList.add(new BankTransaction("03/12/2021", 200));

        bankStatementPrinter.print(transactionList);

        verify(bankConsole).printLine("DATE | AMOUNT | BALANCE");
        verify(bankConsole).printLine("03/12/2021 | 200.00 | 200.00");
        verify(bankConsole).printLine("02/12/2021 | -100.00 | 0.00");
        verify(bankConsole).printLine("01/12/2021 | 100.00 | 100.00");
    }

}