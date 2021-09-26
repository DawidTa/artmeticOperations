package pl.kurs.test4dt.model;

import lombok.Data;
import pl.kurs.test4dt.validation.OperatorExist;

@Data
public class AritmeticModel {
    private double n1;
    private double n2;
    @OperatorExist
    private String operator;
}
