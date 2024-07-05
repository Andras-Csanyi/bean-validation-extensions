package com.andrascsanyi.beanvalidationextensions;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TrimmedSizeValidator implements ConstraintValidator<TrimmedSize, String> {

    private int min;
    private int max;
    private String message;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.trim().length() < min || value.trim().length() > max) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(TrimmedSize constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        message = constraintAnnotation.message();
    }
}
