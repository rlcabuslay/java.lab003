package lab003.FileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import lab003.Bank.BankAccount;
import lab003.Transaction.Transaction;
import lab003.Transaction.TransactionDeposit;
import lab003.Transaction.TransactionWithdraw;

public class TransactionsTxtFileWriter extends TransactionsTxtFile {
    private float amount;
    private boolean isDeposit;

    public TransactionsTxtFileWriter(String fileName, float amount, boolean isDeposit, BankAccount bankAccount) {
        super(fileName, bankAccount);
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    public void write() {
        FileWriter fileWriter = null;
        PrintWriter out = null;

        try {
            fileWriter = new FileWriter(txtFile, true);
            out = new PrintWriter(fileWriter);

            Transaction transaction = null;
            if (isDeposit) {
                transaction = new TransactionDeposit(amount);
            } else {
                transaction = new TransactionWithdraw(amount, bankAccount.getCurrentBalance());
            }
            bankAccount.getTransactionList().add(transaction);
            
            out.println(transaction.toString());
            
            System.out.println("Transaction Successful!!!");
            
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

