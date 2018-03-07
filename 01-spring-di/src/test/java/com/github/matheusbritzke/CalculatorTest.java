package com.github.matheusbritzke;

import com.github.matheusbritzke.calculator.Calculator;
import com.github.matheusbritzke.configurationApp.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculator(){
        Assert.assertNotNull(calculator);
    }

    @Test
    public void sum(){
        double sum = calculator.calculate(2,2, "+");
        Assert.assertEquals(4.0, sum, 0);
    }

    @Test
    public void subtraction(){
        double sub = calculator.calculate(2, 2, "-");
        Assert.assertEquals(0.0, sub, 0);
    }

    @Test
    public void multiplication(){
        double mult = calculator.calculate(3,3, "*");
        Assert.assertEquals(9, mult, 0);
    }

    @Test
    public void division(){
        double div = calculator.calculate(16, 4, "/");
        Assert.assertEquals(4, div, 0);
    }
}
