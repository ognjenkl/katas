package tdd.bankKata2;

public class BankAccount {
    private BankTransactionRepository bankTransactionRepository;

    public BankAccount(BankTransactionRepository bankTransactionRepository) {
        this.bankTransactionRepository = bankTransactionRepository;
    }

    public void deposit(int amount) {
        bankTransactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        bankTransactionRepository.addWithdraw(amount);
    }

    public void printStatement() {
//        throw new UnsupportedOperationException();
    }
}
