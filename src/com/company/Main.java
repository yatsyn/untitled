package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("do yu like a random joke or one by one? (1- random, 0 -one by one)");
        String choose = scanner.nextLine();

        iJokeTimer jokeTimer = new JokeTimer();

        if (choose != null && choose.equals("1"))   {
            jokeTimer.setModeTimer(ModeTimer.RANDOM);
        }   else if (choose != null && choose.equals("0"))  {
            jokeTimer.setModeTimer(ModeTimer.ASC);
        }   else {
            System.out.println("one by one");
        }



        jokeTimer.runJokeTimer();


    }
}
