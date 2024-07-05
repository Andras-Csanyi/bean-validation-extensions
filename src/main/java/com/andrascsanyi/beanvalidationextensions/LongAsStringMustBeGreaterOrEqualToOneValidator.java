package com.andrascsanyi.beanvalidationextensions;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Validator implemenetation for {@link LongAsStringMustBeGreaterOrEqualToOne} constraint.
 */
public class LongAsStringMustBeGreaterOrEqualToOneValidator
        implements ConstraintValidator<LongAsStringMustBeGreaterOrEqualToOne, String> {

    private final Logger log = LoggerFactory.getLogger(LongAsStringMustBeGreaterOrEqualToOne.class);
    private String message;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty() || value.isBlank() || value.trim().isEmpty()) {
            return true;
        }

        try {
            long longValue = Long.parseLong(value);

            boolean isValid = longValue >= 1;

            if (!isValid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            }

            return isValid;

        } catch (NumberFormatException e) {
            log.warn("Could not parse long value: {}", value);
        }
        return false;
    }

    @Override
    public void initialize(LongAsStringMustBeGreaterOrEqualToOne constraintAnnotation) {
        message = constraintAnnotation.message();
    }
}
