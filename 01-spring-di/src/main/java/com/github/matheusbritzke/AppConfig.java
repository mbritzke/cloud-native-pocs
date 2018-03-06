package com.github.matheusbritzke;

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
        return mapOperations;
    }
}
