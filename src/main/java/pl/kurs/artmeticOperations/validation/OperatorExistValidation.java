package pl.kurs.artmeticOperations.validation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kurs.artmeticOperations.service.OperationFacade;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OperatorExistValidation implements ConstraintValidator<OperatorExist, String> {

    @Autowired
    OperationFacade operationFacade;

    @Override
    public boolean isValid(String operator, ConstraintValidatorContext constraintValidatorContext) {
        return operationFacade.getCodes().contains(operator);
    }
}
