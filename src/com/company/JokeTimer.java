package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ivan on 4/21/16.
 */
public class JokeTimer implements iJokeTimer {
    private static final float PAUSE = 6000;
    private static final long MILLS = 1349333576;
    private boolean randomOn = false;
    private long startTime = (System.currentTimeMillis() - MILLS);
    private List<String> jokesArray = JokeReader.initArrFromFile();
    private List<Integer> jokesThatWasShown = new ArrayList<Integer>();


    public void setRandom(boolean randomValue) {
        this.randomOn = randomValue;
    }

    public void runJokeTimer() {

        if (randomOn == true) {
            printRandomJoke();
        } else {
            printJokesOneByOne();
        }
    }

    private void printRandomJoke() {

        Random random = new Random();
        Integer number = (Integer) random.nextInt(jokesArray.size());

        for (int i = 0; i < jokesArray.size(); i++) {
            if (timer(startTime) == true) {
                if (!jokesThatWasShown.contains(number)) {
                    System.out.println(jokesArray.get(number));
                    jokesThatWasShown.add(number);
                    number = (Integer) random.nextInt(jokesArray.size());
                    startTime = (System.currentTimeMillis() - MILLS);
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
        System.out.println(startTime);

        for (int i = 0; i < jokesArray.size(); i++) {
            if (timer(startTime) == true) {
                System.out.println(jokesArray.get(i));
                startTime = (System.currentTimeMillis() - MILLS);
            } else {
                i--;
            }

        }
    }

    private boolean timer(long t) {
        long timeRangeTemp = (System.currentTimeMillis()- MILLS);
        if (timeRangeTemp - t > PAUSE) {
            return true;
        }
        return false;
    }
}