package br.org.LibraryManagement.util;

import java.util.Random;

public class RandomNumbers {

    public static String createRandomNumbers(int numbers){
        Random random = new Random();
        int number = numbers;
        StringBuilder randomString= new StringBuilder();
        for (int n = 0; n < numbers; n++) {

            int randomNumber = random.nextInt(10);
            randomString.append(randomNumber);


        }
        return randomString.toString();
    }
}
