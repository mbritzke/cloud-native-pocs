package com.github.matheusbritzke;

import org.springframework.stereotype.Component;

@Component
public class Sum implements Operation {

    @Override
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
