package pl.kurs.test4dt.model.operations;

import org.springframework.stereotype.Service;
import pl.kurs.test4dt.model.operations.Operator;

@Service
public class SubstractionOperatorImpl implements Operator {
    @Override
    public double calculate(double n1, double n2) {
        return n1 - n2;
    }

    @Override
    public String code() {
        return "-";
    }
}
