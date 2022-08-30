package tdd.bankKata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private final Clock clock;
    private final List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(int amount) {
        transactions.add(new Transaction(clock.todayDateAsString(), amount));

    }

    public void addWithdraw(int amount) {
        transactions.add(new Transaction(clock.todayDateAsString(), -amount));

    }

    public List<Transaction> getAll() {
        return transactions;
    }
}
