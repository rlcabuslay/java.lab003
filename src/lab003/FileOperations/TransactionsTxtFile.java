package lab003.FileOperations;

import java.io.File;

import lab003.Bank.BankAccount;

public abstract class TransactionsTxtFile {
    protected File txtFile;
    protected BankAccount bankAccount;
    
    public TransactionsTxtFile(String fileName, BankAccount bankAccount) {
        this.txtFile = new File(fileName);
        this.bankAccount = bankAccount;
    }
}
