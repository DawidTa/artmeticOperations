package pl.kurs.test4dt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kurs.test4dt.validation.OperatorExist;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AritmeticModel {
    private double n1;
    private double n2;
    @OperatorExist
    private String operator;
}
