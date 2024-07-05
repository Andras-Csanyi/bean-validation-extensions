package com.andrascsanyi.beanvalidationextensions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

/**
 * This constraint describes the case when the provided input {@link String} must be equal to 0 when it is parsed as
 * {@link Long}.
 *
 * <p>
 * The validation judges the negative value, the null, empty or blank string values to be valid.
 *
 * <p>
 * <b>Use case:</b> This validation annotation is used to check values coming via GraphQL where the ID is
 * {@link String}.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LongAsStringMustBeZeroValidator.class)
@Documented
public @interface LongAsStringMustBeZero {
    
    /**
     * The error message that will be added to {@link ConstraintViolation} when the constraint is violated.
     */
    String message() default "{com.andrascsanyi.beanvalidationextensions.LongAsStringMustBeZero}";

    /**
     * At which groups the constraint going to be validated.
     */
    Class<?>[] groups() default {};

    /**
     * The payload.
     */
    Class<? extends Payload>[] payload() default {};
}
