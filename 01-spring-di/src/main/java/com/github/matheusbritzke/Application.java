package com.github.matheusbritzke;

import com.github.matheusbritzke.calculator.Calculator;
import com.github.matheusbritzke.configurationApp.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String args[]){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator currentCalculator = (Calculator) applicationContext.getBean("calculator");
        System.out.println(currentCalculator.calculate(3,1, "+"));
        System.out.println(currentCalculator.calculate(2, 2,"-"));
    }
}
