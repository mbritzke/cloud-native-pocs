package com.github.matheusbritzke.configurationApp;

import com.github.matheusbritzke.calculator.Calculator;
import com.github.matheusbritzke.functions.*;
import com.github.matheusbritzke.maps.MapOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.github.matheusbritzke")
public class AppConfig {

    @Bean
    public Calculator calculator(MapOperations mapOperations){
        Calculator calculator = new Calculator(mapOperations);
        return calculator;
    }

    @Bean
    public MapOperations mapOperations(){
        MapOperations mapOperations = new MapOperations();
        mapOperations.getMapOperation().put("+", new Sum());
        mapOperations.getMapOperation().put("-", new Subtraction());
        mapOperations.getMapOperation().put("*", new Multiplication());
        mapOperations.getMapOperation().put("/", new Division());
        mapOperations.getMapOperation().put("^", new Pow());
        return mapOperations;
    }
}
