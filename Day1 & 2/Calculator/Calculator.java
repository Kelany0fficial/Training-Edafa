package org.example;

import java.util.Scanner;

public class Main {

    // Addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Subtraction
    public static double sub(double num1, double num2) {
        return num1 - num2;
    }

    // Multiplication
    public static double multi(double num1, double num2) {
        return num1 * num2;
    }

    // Division
    public static double div(double num1, double num2) {

        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return num1 / num2;
    }

    // Modulus / Remainder
    public static double pers(double num1, double num2) {

        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return num1 % num2;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== CALCULATOR ==========");

            // First number
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            // Operator
            System.out.print("Enter operator (+, -, *, /, %): ");
            char operator = scanner.next().charAt(0);

            // Second number
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result;

            try {

                switch (operator) {

                    case '+':
                        result = add(num1, num2);
                        break;

                    case '-':
                        result = sub(num1, num2);
                        break;

                    case '*':
                        result = multi(num1, num2);
                        break;

                    case '/':
                        result = div(num1, num2);
                        break;

                    case '%':
                        result = pers(num1, num2);
                        break;

                    default:
                        System.out.println("Invalid operator!");
                        continue;
                }

                System.out.println("Result = " + result);

            } catch (ArithmeticException e) {

                System.out.println("Error: " + e.getMessage());
            }

            // Ask user to continue
            System.out.print("Do you want another calculation? (y/n): ");
            char choice = scanner.next().charAt(0);

            if (choice == 'n' || choice == 'N') {
                System.out.println("Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}