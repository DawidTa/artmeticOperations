package pl.arithmeticOperations.service;

import org.springframework.stereotype.Service;
import pl.arithmeticOperations.model.ArithmeticModel;
import pl.arithmeticOperations.model.Operator;

import java.util.List;
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

    public double operationResult(ArithmeticModel arithmeticModel) {
        return operators.get(arithmeticModel.getOperator()).calculate(arithmeticModel.getN1(), arithmeticModel.getN2());
    }

    public List<String> getCodes() {
        return operators.keySet().stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
