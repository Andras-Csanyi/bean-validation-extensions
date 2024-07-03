package com.andrascsanyi.beanvalidationextensions.longasstringmustbezero;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Set;
import java.util.stream.Stream;
import jakarta.validation.ConstraintViolation;
import com.andrascsanyi.beanvalidationextensions.BeanValidationExtensionsApplicationTests;
import com.andrascsanyi.beanvalidationextensions.LongAsStringMustBeZero;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LongAsStringMustBeZeroTests extends BeanValidationExtensionsApplicationTests {

    public static Stream<Arguments> testDataDefaultGroup() {
        return Stream.of(Arguments.of(DefaultGroupEntity.builder().id("0").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id("1").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id(null).build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id("").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id(" ").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id("-1").build(), 0));
    }

    public static Stream<Arguments> testDataCustomGroup() {
        return Stream.of(Arguments.of(CustomGroupEntity.builder().id("0").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id("1").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id(null).build(), 0),
                Arguments.of(CustomGroupEntity.builder().id("").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id(" ").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id("-1").build(), 0));
    }

    @ParameterizedTest
    @MethodSource("testDataDefaultGroup")
    public void testDefaultGroup(DefaultGroupEntity e, Integer expected) {
        assertThat(validator.validate(e).size()).isGreaterThanOrEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testDataCustomGroup")
    public void testCustomGroup(CustomGroupEntity e, Integer expected) {
        assertThat(validator.validate(e, CustomGroup.class).size()).isGreaterThanOrEqualTo(expected);
    }

    @Test
    public void testDefaultErrorMessage() {

        DefaultErrorMessageEntity entity = DefaultErrorMessageEntity.builder().id("1").build();
        Set<ConstraintViolation<DefaultErrorMessageEntity>> violations = validator.validate(entity);
        assertThat(violations.size()).isEqualTo(1);

        String errorMessage = violations.stream().findFirst().get().getMessage();
        String expectedErrorMessage = String.format("{%s}", LongAsStringMustBeZero.class.getName());

        assertThat(errorMessage)
                .withFailMessage(String.format("result: %s; \n expectedResult: %s", errorMessage, expectedErrorMessage))
                .endsWith(expectedErrorMessage);
    }


    @Test
    public void testCustomErrorMessage() {

        CustomErrorMessageEntity entity = CustomErrorMessageEntity.builder().id("1").build();
        Set<ConstraintViolation<CustomErrorMessageEntity>> violations = validator.validate(entity);
        assertThat(violations.size()).isEqualTo(1);

        String errorMessage = violations.stream().findFirst().get().getMessage();
        String expectedErrorMessage = "Custom Error Message";

        assertThat(errorMessage)
                .withFailMessage(String.format("result: %s; \n expectedResult: %s", errorMessage, expectedErrorMessage))
                .endsWith(expectedErrorMessage);
    }
}
