package com.andrascsanyi.beanvalidationextensions;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator implementation for {@link LongValueMustBe} constraint.
 */
public class LongValueMustBeValidator implements ConstraintValidator<LongValueMustBe, Long> {
    private Long mustBe;
    private String message;

    @Override
    public void initialize(LongValueMustBe constraintAnnotation) {
        mustBe = constraintAnnotation.mustBe();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (!value.equals(mustBe)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }
}
