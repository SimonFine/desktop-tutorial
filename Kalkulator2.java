package com.paczka;

import java.util.Scanner;

public class Kalkulator2 {

    private static void endProgram() {
        System.out.println("Bye!");
        System.exit(0);
    }

    private static void getHelp() {
        System.out.println("The program calculates the addition and substraction");
    }

    private static void printException() {
        System.out.println("Invalid expression");
    }

    private static String formatExpression(String array) {

        String converted = array.replaceAll("\\s+|,|\\[|]", "")
                .replaceAll("(--)+|\\++", "+")
                .replaceAll("(---)+|\\+-|-\\+|-", "-")
                .replaceAll("\\+", " +")
                .replaceAll("-", " -");
        return converted.trim();
    }

    private static void calculateResult(String input) {
        int result = 0;
        String[] inputArray = input.split(" ");
        for (String s : inputArray) {
            result += Integer.parseInt(s);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.matches("^/\\w")) {
                System.out.println("Unknown command");
            } else if (userInput.matches("/exit")) {
                endProgram();
            } else if (userInput.matches("/help")) {
                getHelp();
            } else {
                try {
                    calculateResult(formatExpression(userInput));
                } catch (Exception e) {
                    printException();
                }
            }
        }
    }
}