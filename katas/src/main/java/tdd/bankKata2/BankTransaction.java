package tdd.bankKata2;

import java.util.Objects;

public class BankTransaction {

    private String date;
    private Integer amount;

    public BankTransaction(String date, Integer amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }

    public String getDate() {
        return date;
    }

    public Integer getAmount() {
        return amount;
    }
}
