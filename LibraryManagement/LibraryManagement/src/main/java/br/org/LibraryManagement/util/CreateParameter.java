package br.org.LibraryManagement.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class CreateParameter {

        public static String createString(String message) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(message);
            return scanner.nextLine();
        }

        public static int createInt(String message){
            Scanner scanner = new Scanner(System.in);
            int number = 0;
            while (true){

                System.out.print(message);
                if (scanner.hasNextInt()){
                    number = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Please type a number!");
                    scanner.next();
                }
            }
            return number;
        }
        public static double createDouble(String message){
            Scanner scanner = new Scanner(System.in);
            double number = 0;
            while (true){

                System.out.print(message);
                if (scanner.hasNextDouble()){
                    number = scanner.nextDouble();
                    break;
                }else {
                    System.out.println("Please type a number!");
                    scanner.next();
                }
            }

            return number;
        }

    public static long createLong(String message){
        Scanner scanner = new Scanner(System.in);
        long number = 0;
        while (true){

            System.out.print(message);
            if (scanner.hasNextLong()){
                number = scanner.nextLong();
                break;
            }else {
                System.out.println("Please type a number!");
                scanner.next();
            }
        }
        return number;
    }
    }

