package com.number;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {

    private static final String PATH_TO_RANDOM_NUMBERS_FILE = "numbers.csv";
    private static final String DELIMITER = ",";


    public static IntStream getRandomNumbersStream() throws IOException {
        Random rnd = new Random();
        long startTime = System.nanoTime();

        IntStream numbers = rnd.ints(100, 0, 10000);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        System.out.println("NanoSeconds: " + duration);

        writeDataToFile(numbers);
        return numbers;
    }

    private static void writeDataToFile(IntStream numbers) throws IOException {
        FileWriter writer = new FileWriter(PATH_TO_RANDOM_NUMBERS_FILE);

        String collect = numbers.mapToObj(String::valueOf)
                .collect(Collectors.joining(DELIMITER));

        writer.write(collect);
        writer.close();
    }
}
