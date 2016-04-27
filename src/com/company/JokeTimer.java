package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ivan on 4/21/16.
 */
public class JokeTimer implements iJokeTimer {
    private static final float PAUSE = 6000;

    private ModeTimer modeTimer = ModeTimer.ASC;
    //enum

    private IJokeConsolePrinter jokeConsolePrinter = new JokeConsolePrinter();
    private JokeReader jokeReader = new JokeReader();
    List<String> jokesArray = jokeReader.initArrFromFile();
    private List<Integer> jokesThatWasShown = new ArrayList<Integer>();

    public void setModeTimer(ModeTimer modeTimer) {
        this.modeTimer = modeTimer;
    }


    public void runJokeTimer() {

        if (modeTimer.equals(ModeTimer.RANDOM)) {
            printRandomJoke();
        } else {
            printJokesOneByOne();
        }
    }

    private void printRandomJoke() {

        Random random = new Random();
        Integer number = (Integer) random.nextInt(jokesArray.size());
        long now1 = System.currentTimeMillis();

        for (int i = 0; i < jokesArray.size(); i++) {
            long now2 = System.currentTimeMillis();
            if (now2 - now1 >= PAUSE) {
                if (!jokesThatWasShown.contains(number)) {
                    jokeConsolePrinter.print(jokesArray.get(number));
                    jokesThatWasShown.add(number);
                    number = (Integer) random.nextInt(jokesArray.size());
                    now1 = System.currentTimeMillis();
                } else {
                    i--;
                    number = (Integer) random.nextInt(jokesArray.size());

                }
            } else {
                i--;
            }
        }
    }

    private void printJokesOneByOne() {

        long now1 = System.currentTimeMillis();
        for (int i = 0; i < jokesArray.size(); i++) {
            long now2 = System.currentTimeMillis();
            if (now2 - now1 >= PAUSE) {
                jokeConsolePrinter.print(jokesArray.get(i));
                now1 = System.currentTimeMillis();
            } else {
                i--;
            }

        }
    }
}