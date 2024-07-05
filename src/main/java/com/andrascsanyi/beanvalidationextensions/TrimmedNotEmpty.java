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
 * This constraint describes that the provided {@link String} value cannot be empty after it is trimmed.
 * <p>
 * The validator judges null to be invalid value.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TrimmedNotEmptyValidator.class)
@Documented
public @interface TrimmedNotEmpty {

    /**
     * The error message which will be added to {@link ConstraintViolation} instance when the constraint is violated.
     */
    String message() default "{com.andrascsanyi.beanvalidationextensions.TrimmedNotEmpty}";

    /**
     * The list of groups where the constraint will be checked.
     */
    Class<?>[] groups() default {};

    /**
     * The payload.
     */
    Class<? extends Payload>[] payload() default {};
}
