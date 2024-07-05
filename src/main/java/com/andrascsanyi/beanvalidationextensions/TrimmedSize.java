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
 * This constraint describes that the provided {@link String} length must be between the provided minimum (inclusive)
 * and maximum (exclusive) length after it is trimmed.
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TrimmedSizeValidator.class)
@Documented
public @interface TrimmedSize {

    /**
     * The error message which will be added to {@link ConstraintViolation} when the constraint is violated.
     */
    String message() default "{com.andrascsanyi.beanvalidationextensions.TrimmedSize}";

    /**
     * List of groups when the constraint is going to be checked.
     */
    Class<?>[] groups() default {};

    /**
     * The payload.
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * The minimum length of the provided {@link String}.
     */
    int min() default 0;

    /**
     * The maximum length of the {@link String}.
     */
    int max() default Integer.MAX_VALUE;
}
