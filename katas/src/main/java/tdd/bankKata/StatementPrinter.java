package tdd.bankKata;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {
    private static final String HEADER = "DATE | AMOUNT | BALANCE";
    private final Console console;
    private final DecimalFormat decimalFormatter = new DecimalFormat("0.00");

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(HEADER);

        AtomicInteger runningBalance = new AtomicInteger(0);
        transactions.stream()
                .map(tr -> statementLine(tr, runningBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }

    private String statementLine(Transaction transaction, AtomicInteger runningBalance) {
        return transaction.getDate()
                + " | "
                + decimalFormatter.format(transaction.getAmount())
                + " | "
                + decimalFormatter.format(runningBalance.addAndGet(transaction.getAmount()));
    }
}
