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
        String sum = calculator.calculate(2,2, "+");
        Assert.assertEquals("4.0", sum);
    }

    @Test
    public void subtraction(){
        String sub = calculator.calculate(2, 2, "-");
        Assert.assertEquals("0.0", sub);
    }

    @Test
    public void multiplication(){
        String mult = calculator.calculate(3,3, "*");
        Assert.assertEquals("9.0", mult);
    }

    @Test
    public void division(){
        String div = calculator.calculate(16, 4, "/");
        Assert.assertEquals("4.0", div);
    }

    @Test
    public void invalidOperation(){
        String invalid = calculator.calculate(16, 4, "a");
        String expected = "16.0 Invalid Operation 4.0 = Erro";
        Assert.assertEquals(expected, invalid);
    }
}
