package com.github.matheusbritzke.calculator;

import com.github.matheusbritzke.maps.MapOperations;

public class Calculator {

    private MapOperations mapOperations;

    public Calculator(MapOperations mapOperations) {
        this.mapOperations = mapOperations;
    }

    public double calculate(double firstNumber, double secondNumber, String operation){
        return mapOperations.getMapOperation().get(operation).calculate(firstNumber, secondNumber);
    }
}
