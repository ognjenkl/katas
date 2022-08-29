package tdd.bankKata;


import java.util.List;

public class Account {

    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.addWithdraw(amount);
    }

    public void printStatement() {
        List<Transaction> transactionList = transactionRepository.getAll();
        statementPrinter.print(transactionList);
    }
}
