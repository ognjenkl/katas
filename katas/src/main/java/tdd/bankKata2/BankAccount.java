package tdd.bankKata2;

public class BankAccount {
    private BankTransactionRepository bankTransactionRepository;
    private final BankStatementPrinter bankStatementPrinter;

    public BankAccount(BankTransactionRepository bankTransactionRepository, BankStatementPrinter bankStatementPrinter) {
        this.bankTransactionRepository = bankTransactionRepository;
        this.bankStatementPrinter = bankStatementPrinter;
    }

    public void deposit(int amount) {
        bankTransactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        bankTransactionRepository.addWithdraw(amount);
    }

    public void printStatement() {
        bankStatementPrinter.print(bankTransactionRepository.getAll());
    }
}
