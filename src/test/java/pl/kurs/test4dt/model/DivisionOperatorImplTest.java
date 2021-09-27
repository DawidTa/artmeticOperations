package pl.kurs.test4dt.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionOperatorImplTest {

    private DivisionOperatorImpl divisionOperator;

    @Before
    public void setUp() throws Exception {
        divisionOperator = new DivisionOperatorImpl();
    }

    @Test
    public void calculate() {
        double n1 = 10.0;
        double n2 = 5.0;

        double result = divisionOperator.calculate(n1, n2);

        Assert.assertEquals(2.0, result,0);
    }
}