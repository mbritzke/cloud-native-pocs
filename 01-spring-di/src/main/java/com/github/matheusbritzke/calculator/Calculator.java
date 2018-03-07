package com.github.matheusbritzke.calculator;

import com.github.matheusbritzke.maps.HistoryOperations;
import com.github.matheusbritzke.maps.MapOperations;

public class Calculator {

    private MapOperations mapOperations;
    private HistoryOperations historyOperations;

    public Calculator(MapOperations mapOperations, HistoryOperations historyOperations) {
        this.mapOperations = mapOperations;
        this.historyOperations = historyOperations;
    }

    public double calculate(double firstNumber, double secondNumber, String operation){
        double answer = mapOperations.getMapOperation().get(operation).calculate(firstNumber, secondNumber);
        saveOperation(firstNumber, secondNumber, operation, answer);
        return answer;
    }

    private void saveOperation(double firstNumber, double secondNumber, String operation, double ans){
        String completeOperation = firstNumber + " "+ operation + " " + secondNumber + " = " + ans;
        historyOperations.getHistoryOperations().get(operation).add(completeOperation);
    }

    public void showHistory(){
        for(String aux: historyOperations.getHistoryOperations().keySet())
            System.out.println(historyOperations.getHistoryOperations().get(aux) + "\n");
    }
}
