package lab003.Bank;

import lab003.Transaction.Transaction;
import lab003.Transaction.TransactionList;

public class BankAccount {
    TransactionList transactionList;

    public BankAccount() {
        this.transactionList = new TransactionList();
    }

    public TransactionList getTransactionList() {
        return transactionList;
    }

    public float getCurrentBalance() {
        float currentBalance = 0F;
        for (Transaction t : transactionList.getList()) {
            currentBalance += t.getAmount();
        }
        return currentBalance;
    }

    public void printStatement() {
        for (Transaction t : transactionList.getList()) {
            System.out.println(t.toString());
        }
    }
}
