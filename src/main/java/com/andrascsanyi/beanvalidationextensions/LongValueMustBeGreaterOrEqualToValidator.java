package com.andrascsanyi.beanvalidationextensions;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * The validator implementation of {@link LongValueMustBeGreaterOrEqualTo} constraint.
 */
public class LongValueMustBeGreaterOrEqualToValidator
        implements ConstraintValidator<LongValueMustBeGreaterOrEqualTo, Long> {

    private Long mustBeGreaterToEqualToValue;
    private String message;

    @Override
    public void initialize(LongValueMustBeGreaterOrEqualTo constraintAnnotation) {
        mustBeGreaterToEqualToValue = constraintAnnotation.mustBeGreaterOrEqualTo();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value < mustBeGreaterToEqualToValue) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }
}
