package pl.arithmeticOperations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.arithmeticOperations.validation.OperatorExist;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArithmeticModel {
    private double n1;
    private double n2;
    @OperatorExist
    private String operator;
}
