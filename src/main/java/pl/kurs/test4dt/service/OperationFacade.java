package pl.kurs.test4dt.service;

import org.springframework.stereotype.Service;
import pl.kurs.test4dt.model.operations.AritmeticModel;
import pl.kurs.test4dt.model.operations.Operator;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OperationFacade {
    private Map<String, Operator> operators;


    public OperationFacade(Set<Operator> operatorSet) {
        this.operators = operatorSet.stream().collect(Collectors.toMap(Operator::code, Function.identity()));
    }

    public double operationResult(AritmeticModel aritmeticModel) {
        return operators.get(aritmeticModel.getOperator()).calculate(aritmeticModel.getN1(), aritmeticModel.getN2());
    }
}
