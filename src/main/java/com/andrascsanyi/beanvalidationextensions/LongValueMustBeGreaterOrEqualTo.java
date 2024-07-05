package com.andrascsanyi.beanvalidationextensions;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This constraint describes the case when the provided {@link Long} value must be greater or equal to the provided
 * parameters.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LongValueMustBeGreaterOrEqualToValidator.class)
@Documented
public @interface LongValueMustBeGreaterOrEqualTo {

    /**
     * The value which to the provided input must he greater or equal to.
     */
    long mustBeGreaterOrEqualTo() default Long.MIN_VALUE;

    /**
     * The error message will be shown in the {@link ConstraintViolation}.
     */
    String message() default "{com.andrascsanyi.beanvalidationextensions.LongValueMustBeGreaterOrEqualTo}";

    /**
     * In which group the constraint check will be executed.
     */
    Class<?>[] groups() default {};

    /**
     * The payload.
     */
    Class<? extends Payload>[] payload() default {};

}
