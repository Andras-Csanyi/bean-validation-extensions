package com.andrascsanyi.beanvalidationextensions;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * The validator implementation for {@link TrimmedNotEmpty} constraint.
 */
public class TrimmedNotEmptyValidator implements ConstraintValidator<TrimmedNotEmpty, String> {

    private String message;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.trim().isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(TrimmedNotEmpty constraintAnnotation) {
        message = constraintAnnotation.message();
    }
}
