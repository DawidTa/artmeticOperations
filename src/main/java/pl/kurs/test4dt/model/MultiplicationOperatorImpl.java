package pl.kurs.test4dt.model;

public class MultiplicationOperatorImpl implements Operator {
    @Override
    public double calculate(double n1, double n2) {
        return n1 * n2;
    }

    @Override
    public String code() {
        return "*";
    }
}
