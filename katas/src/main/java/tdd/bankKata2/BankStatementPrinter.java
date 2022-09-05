package tdd.bankKata2;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BankStatementPrinter {

    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
    private BankConsole bankConsole;

    public BankStatementPrinter(BankConsole bankConsole) {

        this.bankConsole = bankConsole;
    }

    public void print(List<BankTransaction> transactionList) {
        bankConsole.printLine(STATEMENT_HEADER);
        AtomicInteger balance = new AtomicInteger(0);
        transactionList.stream()
                .map(tr -> transactionAsStatementLine(tr, balance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(bankConsole::printLine);
    }

    private String transactionAsStatementLine(BankTransaction bankTransaction, AtomicInteger balance) {
        return bankTransaction.getDate()
                + " | "
                + DECIMAL_FORMAT.format(bankTransaction.getAmount())
                + " | "
                + DECIMAL_FORMAT.format(balance.addAndGet(bankTransaction.getAmount()));
    }
}
