package tdd.bankKata2;

import java.util.ArrayList;
import java.util.List;

public class BankTransactionRepository {

    private List<BankTransaction> bankTransactionList = new ArrayList<>();
    private BankClock bankClock;

    public BankTransactionRepository(BankClock bankClock) {
        this.bankClock = bankClock;
    }

    public List<BankTransaction> getAll() {
        return bankTransactionList;
    }

    public void addDeposit(int amount) {
        BankTransaction transaction = new BankTransaction(getTodayDateAsString(), amount);
        bankTransactionList.add(transaction);
    }

    private String getTodayDateAsString() {
        return bankClock.todayDateAsString();
    }

    public void addWithdraw(int amount) {
        bankTransactionList.add(new BankTransaction(getTodayDateAsString(), -amount));
    }
}
