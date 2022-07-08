package pl.kurs.test4dt.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiplicationOperatorImplTest {

    private MultiplicationOperatorImpl multiplicationOperator;

    @Before
    public void setUp() throws Exception {
        multiplicationOperator = new MultiplicationOperatorImpl();
    }

    @Test
    public void calculate() {
        double n1 = 2.0;
        double n2 = 3.0;

        double result = multiplicationOperator.calculate(n1, n2);

        Assert.assertEquals(6.0, result, 0);
    }
}