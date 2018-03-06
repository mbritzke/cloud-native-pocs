package com.github.matheusbritzke;

import org.springframework.beans.factory.annotation.Autowired;

public class Calculator {

    private MapOperations mapOperations;

    @Autowired
    public Calculator(MapOperations mapOperations) {
        this.mapOperations = mapOperations;
    }

    public double calculate(double firstNumber, double secondNumber, String operation){
        return mapOperations.getMapOperation().get(operation).calculate(firstNumber, secondNumber);
    }
}
