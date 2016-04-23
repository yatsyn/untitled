package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("do yu like a random joke or one by one? (1- random, 0 -one by one)");
        String choose = scanner.nextLine();

        JokeTimer jokeTimer = new JokeTimer();

        if (choose != null && choose.equals("1"))   {
            jokeTimer.setRandom(true);
        }   else if (choose != null && choose.equals("0"))  {
            jokeTimer.setRandom(false);
        }   else {
            System.out.println("one by one");
        }



        jokeTimer.runJokeTimer();


    }
}
