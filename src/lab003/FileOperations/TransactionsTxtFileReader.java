package lab003.FileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lab003.Bank.BankAccount;
import lab003.Transaction.Transaction;
import lab003.Transaction.TransactionList;
import lab003.Transaction.TransactionRead;

public class TransactionsTxtFileReader extends TransactionsTxtFile {

    public TransactionsTxtFileReader(String fileName, BankAccount bankAccount) {
        super(fileName, bankAccount);
    }

    public TransactionList read() {
        FileReader fileReader = null;
        BufferedReader reader = null;

        try {
            fileReader = new FileReader(txtFile);
            reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                Float amount = Float.parseFloat(line + "F");
                Transaction transaction = new TransactionRead(amount);
                bankAccount.getTransactionList().add(transaction);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return bankAccount.getTransactionList();
    }
}
