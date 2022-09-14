package pl.arithmeticOperations.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdditionOperatorImplTest {

    private AdditionOperatorImpl additionOperator;


    @Before
    public void setUp() throws Exception {
        additionOperator = new AdditionOperatorImpl();
    }

    @Test
    public void calculate() {
        double n1 = 3.0;
        double n2 = 5.0;

        double result = additionOperator.calculate(n1, n2);

        Assert.assertEquals(8.0, result, 0);
    }
}