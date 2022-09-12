package pl.kurs.artmeticOperations.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OperatorExistValidation.class)
public @interface OperatorExist {
    String message() default "Invalid operator";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
