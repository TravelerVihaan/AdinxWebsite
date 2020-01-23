package com.github.vihaan.adinxwebsite.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public interface IValidation<T> {

    boolean isValid(T objectToValidate);

    default boolean validatorCheck(T objectToValidate) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> validationErrors = validator.validate(objectToValidate);
        return validationErrors.isEmpty();
    }
}
