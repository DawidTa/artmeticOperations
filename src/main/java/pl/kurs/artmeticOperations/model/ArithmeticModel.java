package pl.kurs.artmeticOperations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kurs.artmeticOperations.validation.OperatorExist;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArithmeticModel {
    private double n1;
    private double n2;
    @OperatorExist
    private String operator;
}
