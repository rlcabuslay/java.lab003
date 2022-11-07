package lab003.Transaction;

import java.util.ArrayList;
import java.util.List;

public // TODO: use generics?
class TransactionList {
    private List<Transaction> transactions;

    public TransactionList() {
        transactions = new ArrayList<>();
    }

    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getList() {
        return transactions;
    }
}
