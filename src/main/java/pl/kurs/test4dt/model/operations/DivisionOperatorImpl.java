package pl.kurs.test4dt.model.operations;

import org.springframework.stereotype.Service;

@Service
public class DivisionOperatorImpl implements Operator {
    @Override
    public double calculate(double n1, double n2) {
        return n1 / n2;
    }

    @Override
    public String code() {
        return "/";
    }
}
