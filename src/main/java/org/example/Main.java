package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("frequency.txt");

        Scanner scanner = new Scanner(file);

        Map<Character, Integer> alphabetCount = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            alphabetCount.put(c, 0);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            line = line.toLowerCase();

            for (char c : line.toCharArray()) {
                if (alphabetCount.containsKey(c)) {
                    alphabetCount.put(c, alphabetCount.get(c) + 1);
                }
            }
        }
        scanner.close();

        for (Map.Entry<Character, Integer> entry : alphabetCount.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

    }
}