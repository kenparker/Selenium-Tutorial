package com.angelo.common;

import java.util.Scanner;

public class Utility {
    
    public static String enterSomethingFromConsole(String text) {
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
