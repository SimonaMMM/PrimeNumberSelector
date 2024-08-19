package com.number;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.number.PrimeNumbers.getPrimeNumbers;


@RestController
public class ConsumerController {

    @PostMapping("/select-prime")
    public void selectPrimeNumbers() throws IOException {
        getPrimeNumbers();
    }
}
