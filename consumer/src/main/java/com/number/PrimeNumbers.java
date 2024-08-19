package com.number;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {

    private static final String PATH_TO_PRIME_NUMBERS_FILE = "prime_numbers.csv";
    private static final String PATH_TO_RANDOM_NUMBERS_FILE = "numbers.csv";
    private static final String DELIMITER = ",";


    public static void getPrimeNumbers() throws IOException {
        List<List<String>> randomNumbers = readRandomNumbersFromFile();
        List<Integer> primeNumbers = new ArrayList<>();

        for (List<String> numbersPerLine: randomNumbers) {
            for (String numberString : numbersPerLine) {
                try {
                    int number = Integer.parseInt(numberString);
                    if (isPrime(number)) {
                        primeNumbers.add(number);
                    }
                } catch (NumberFormatException exception) {
                    exception.getLocalizedMessage();
                }
            }
        }

        writeDataToFile(getIntStream(primeNumbers));
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static IntStream getIntStream(List<Integer> list)
    {
        return list.stream().mapToInt(Integer::intValue);
    }

    private static List<List<String>> readRandomNumbersFromFile() throws IOException {
        List<List<String>> randomNumbers = new ArrayList<>();

        try {
            randomNumbers = Files.readAllLines(Paths.get(PATH_TO_RANDOM_NUMBERS_FILE))
                    .stream()
                    .map(line -> Arrays.asList(line.split(DELIMITER)))
                    .toList();
        } catch (IOException exception) {
            exception.getLocalizedMessage();
        }

        return randomNumbers;
    }

    private static void writeDataToFile(IntStream numbers) throws IOException {
        FileWriter writer = new FileWriter(PATH_TO_PRIME_NUMBERS_FILE);

        String collect = numbers.mapToObj(String::valueOf)
                .collect(Collectors.joining(DELIMITER));

        writer.write(collect);
        writer.close();
    }
}
