package com.company;

/**
 * Created by ivan on 4/21/16.
 */
public class JokeConsolePrinter implements IJokeConsolePrinter {

    @Override
    public void print(String joke) {
        System.out.println(joke);
    }
}
