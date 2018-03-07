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

    public String calculate(double firstNumber, double secondNumber, String operation){
        boolean statusOperation = validateOperation(operation);
        if(statusOperation){
            double answer = mapOperations.getMapOperations().get(operation).calculate(firstNumber, secondNumber);
            return saveOperations(firstNumber, secondNumber, operation, String.valueOf(answer));
        }
        return saveOperations(firstNumber, secondNumber, "Invalid Operation", "Erro");
    }

    private boolean validateOperation(String operation) {
        String typeOfOperation = "+-*/^";
        return typeOfOperation.contains(operation);
    }

    private String saveOperations(double firstNumber, double secondNumber, String operation, String answer) {
        String completeOperation = firstNumber + " "+ operation + " " + secondNumber + " = " + answer;
        historyOperations.getHistoryOperations().get(operation).add(completeOperation);
        return completeOperation;
    }

    public void showHistory(){
        for(String aux: historyOperations.getHistoryOperations().keySet())
            System.out.println(historyOperations.getHistoryOperations().get(aux) + "\n");
    }
}
