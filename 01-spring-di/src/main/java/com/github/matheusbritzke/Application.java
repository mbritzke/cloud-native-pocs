package com.github.matheusbritzke;

import com.github.matheusbritzke.calculator.Calculator;
import com.github.matheusbritzke.configurationApp.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String args[]){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator currentCalculator = (Calculator) applicationContext.getBean("calculator");

        System.out.println("OPERATIONS: ");
        System.out.println("3+1 = " + currentCalculator.calculate(3,1, "+"));
        System.out.println("2-2 = " + currentCalculator.calculate(2, 2,"-"));
        System.out.println("3*3 = " + currentCalculator.calculate(3, 3,"*"));
        System.out.println("16/4 = " + currentCalculator.calculate(16, 4,"/"));
        System.out.println("5^3 = " + currentCalculator.calculate(5, 3,"^"));

        System.out.println("LIST OF ALL OPERATIONS: ");
        currentCalculator.showHistory();
    }
}
