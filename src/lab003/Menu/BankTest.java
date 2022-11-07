package lab003.Menu;

import static lab003.Menu.MenuSelection.*;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

import lab003.Bank.BankAccount;
import lab003.FileOperations.TransactionsTxtFileReader;

public class BankTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int selection = 0;
        boolean track = true;
        boolean error = true;
        String temp;

        BankAccount bankAccount = new BankAccount();

        ResourceBundle bundle = ResourceBundle.getBundle("lab003.application");
        final String transactionsFilePath = bundle.getString("transactions.txt");
        File transactionsFile = new File(transactionsFilePath);

        try {
            File fileDir = new File(".\\files");
            fileDir.mkdir();
            
            if (transactionsFile.exists()) {
                TransactionsTxtFileReader transactionsTxtFileReader = new TransactionsTxtFileReader(transactionsFilePath, bankAccount);
                transactionsTxtFileReader.read();

            } else {
                transactionsFile.createNewFile();

            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        do {
            while (error == true) {
                try {
                    System.out.println("Select any of the below options");
                    System.out.println("1 --> Deposit\n2 --> Withdraw\n3 --> Statement\n4 --> Balance\n5 --> End Transaction");
                    temp = in.nextLine();
                    selection = Integer.parseInt(temp);
                    error = false;
                    
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input " + e.getMessage());
                    error = true;
                    
                }
            }
            track = menuSelection(selection, track, transactionsFilePath, bankAccount, in);
            error = true;
        } while (track);
        System.out.println("Thank you for your patronage!!");

    }

}
