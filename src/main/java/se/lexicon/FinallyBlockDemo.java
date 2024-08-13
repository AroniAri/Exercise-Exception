package se.lexicon;

import java.util.Scanner;

public class FinallyBlockDemo{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second intiger: ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + result);

        }catch (ArithmeticException e) {
            System.out.println("Error: Divison by zero is not allowed.");
        }finally {
            System.out.println("This is the finally block, which always executes.");
        }
        
    }
}
