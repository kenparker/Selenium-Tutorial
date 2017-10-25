package com.angelo.selenium.udemy.exercises;

import java.util.Scanner;

public class ReadConsole3 {

    public static void main(String[] args) {
        enterSomethingFromConsole("Benutzer ");
    }

        
    private static String enterSomethingFromConsole(String text) {
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {            
            System.err.println("Enter " + text + " :");
            String input = scanner.nextLine();
            if ("q".equals(input)) {
                System.out.println("Exist :");
                System.exit(0);
            }
            System.out.println("Input is : " + input);
            return input;
        }
    }
}
