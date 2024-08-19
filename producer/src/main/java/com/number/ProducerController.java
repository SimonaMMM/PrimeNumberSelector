package com.number;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.number.RandomNumbers.getRandomNumbersStream;

@RestController
public class ProducerController {

    @PostMapping("/generate-numbers")
    public void generateRandomNumbers() throws IOException {
        getRandomNumbersStream();
    }
}