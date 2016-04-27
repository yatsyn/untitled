package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ivan on 01.03.2016.
 */
public class JokeReader {

    private static final String PATH = "/home/ivan/IdeaProjects/untitled/src/com/company/jokes.txt";

    public static List<String> initArrFromFile() {
        List<String> jokes;

        Scanner s = null;
        jokes = new ArrayList<String>();

        try {
            s = new Scanner(new File(PATH));
            while (s.hasNextLine()) {
                jokes.add(s.nextLine());
            }
        } catch (IOException e) {
            throw new JokeReaderException();

        } finally {
            if (s != null) {
                s.close();
            }
        }
        return jokes;
    }
}