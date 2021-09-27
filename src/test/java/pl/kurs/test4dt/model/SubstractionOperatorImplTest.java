package pl.kurs.test4dt.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubstractionOperatorImplTest {

    private SubstractionOperatorImpl substractionOperator;

    @Before
    public void setUp() throws Exception {
        substractionOperator = new SubstractionOperatorImpl();
    }

    @Test
    public void calculate() {
        double n1 = 12.0;
        double n2 = 6.0;

        double result = substractionOperator.calculate(n1, n2);

        Assert.assertEquals(6.0, result, 0);
    }
}