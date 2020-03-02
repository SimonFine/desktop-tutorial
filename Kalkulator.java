package com.paczka;

import java.util.Arrays;
import java.util.Scanner;

public class Kalkulator {

    public static String formatExpression(String[] array) {
        String strArray = Arrays.toString(array);

        String converted1 = strArray.replaceAll("\\s+|,|\\[|]", "");
        String converted2 = converted1.replaceAll("(--)+|\\++", "+");
        String converted3 = converted2.replaceAll("(---)+|\\+-|-\\+|-", "-");
        String allConverted = converted3.replaceAll("\\+", " +").replaceAll("-", " -");
        return allConverted.trim();
    }

    public static int[] fillArray(int[] arrayToFill, String[] stringArray) {
        for (int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = Integer.parseInt(stringArray[i]);
        }
        return arrayToFill;
    }

    public static void calculateResult(int[] calculationArray) {
        int result = 0;
        for (int number : calculationArray) {
            result += number;
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            userInput = scanner.nextLine();
            String[] arrayFromInput1 = userInput.split(" ");

            if (userInput.equals("/exit")) {
                System.out.println("Bye!");
                break;
            } else if (userInput.equals("/help")) {
                System.out.println("The program calculates the addition and substraction");
            } else if(userInput.matches("/.*")) {
                System.out.println("Unknown command");
            } else if (arrayFromInput1.length == 1) {
                System.out.println(userInput);
            } else {
                String formatedExpression = formatExpression(arrayFromInput1);
                String[] arrayOfNumbers = formatedExpression.split(" ");
                int[] array = new int[arrayOfNumbers.length];

                calculateResult(fillArray(array, arrayOfNumbers));
            }
        }

    }
}
