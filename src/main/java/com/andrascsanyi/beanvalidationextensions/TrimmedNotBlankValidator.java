package com.andrascsanyi.beanvalidationextensions;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrimmedNotBlankValidator implements ConstraintValidator<TrimmedNotBlank, String> {

    private final static Logger log = LoggerFactory.getLogger(TrimmedNotBlankValidator.class);
    private String message;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.trim().isBlank()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(TrimmedNotBlank constraintAnnotation) {
        message = constraintAnnotation.message();
    }
}
