package lab003.Menu;

import java.util.Scanner;

import lab003.*;
import lab003.Bank.BankAccount;
import lab003.FileOperations.TransactionsTxtFileWriter;

public class MenuSelection {
    public static  boolean menuSelection(int selection, boolean track, String fileName, BankAccount bankAccount, Scanner in) {
        String temp;
        float amount;
        TransactionsTxtFileWriter transactionsTxtFileWriter = null;
        
        switch (selection) {
            case 1:
                System.out.print("Enter amount to deposit: ");
                temp = in.nextLine();
                amount = Float.parseFloat(temp);
                
                transactionsTxtFileWriter = new TransactionsTxtFileWriter(fileName, amount, true, bankAccount);
                transactionsTxtFileWriter.write();
                break;
                
            case 2:
                System.out.print("Enter amount to withdraw: ");
                temp = in.nextLine();
                amount = Float.parseFloat(temp);
                
                transactionsTxtFileWriter = new TransactionsTxtFileWriter(fileName, amount, false, bankAccount);
                transactionsTxtFileWriter.write();
                break;
                
            case 3:
                System.out.println("Bank Statement: ");
                bankAccount.printStatement();
                break;
                
            case 4:
                System.out.println("Your balance is: " + String.valueOf(bankAccount.getCurrentBalance()));
                break;
                
            case 5:
                System.out.println("Transaction End");
                track = false;
                break;
                
            default:
                System.out.println("Invalid Option");
                System.out.println("Try Again");
                break;
        }
        return track;
    }
}
