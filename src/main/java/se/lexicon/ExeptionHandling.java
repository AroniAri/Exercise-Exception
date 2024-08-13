package se.lexicon;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExeptionHandling {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Result " + result);

        }catch (ArithmeticException e) {
            System.out.println("Error Divison by zero is not allowed");
        }finally {
            System.out.println("End of program.");
        }
    }
}




class OutOfRangeException extends Exception {
    public OutOfRangeException(String message) {
        super(message);
    }
}

class MultipleExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter an integer between 1 and 100: ");
            int number = scanner.nextInt();

            if (number < 1 || number > 100) {
                throw new OutOfRangeException("Number out of range. Please enter a number between 1 and 100.");
            }

            System.out.println("You entered: " + number);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter an integer.");
        } catch (OutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
     class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Withdrawal denied.");
        }
        balance -= amount;
        System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

class CustomExceptionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            account.deposit(500);
            account.withdraw(200);
            account.withdraw(1500); // This will trigger the exception
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

 class NestedTryCatchDemo {
    public  static void main(String[] args){
        try {
            List<String> lines = Files.readAllLines(Paths.get("number.text"));

            for (String lin : lines){
                try {
                    int number = Integer.parseInt(String.valueOf(lines));
                    System.out.println("Parse number:" + number);

                }catch (NumberFormatException e){
                    System.out.println("Error: Unabel to parse '" + lines + "' as an integer");
                }

            }
        } catch (NoSuchFileException e) {
            System.out.println("Error: The file was not found.");
        } catch (IOException e){
            System.out.println("Error: An I/O error occurred.");
        }
    }

}

