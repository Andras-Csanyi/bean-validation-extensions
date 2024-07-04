package com.andrascsanyi.beanvalidationextensions;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This constrait describes the case when the provided {@link Long} value must be the provided {@link Long} value.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LongValueMustBeValidator.class)
@Documented
public @interface LongValueMustBe {
    long mustBe() default 0L;

    String message() default "{com.andrascsanyi.beanvalidationextensions.LongValueMustBe}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
