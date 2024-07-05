package com.andrascsanyi.beanvalidationextensions.trimmednotblank;

import com.andrascsanyi.beanvalidationextensions.BeanValidationExtensionsApplicationTests;
import com.andrascsanyi.beanvalidationextensions.TrimmedNotBlank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Set;
import java.util.stream.Stream;
import jakarta.validation.ConstraintViolation;
import static org.assertj.core.api.Assertions.assertThat;

public class TrimmedNotBlankTests extends BeanValidationExtensionsApplicationTests {

    public static Stream<Arguments> testDataDefaultGroup() {
        return Stream.of(Arguments.of(DefaultGroupEntity.builder().id("").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id(" ").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id("  ").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id("   ").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id(" \t  ").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id(" \n  ").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id(" \r  ").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id(" \f  ").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id(" \s  ").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id("a").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id("a ").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id("a  ").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id(" a  ").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id("  a  ").build(), 0));
    }

    public static Stream<Arguments> testDataCustomGroup() {
        return Stream.of(Arguments.of(CustomGroupEntity.builder().id("").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id(" ").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id("  ").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id("   ").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id(" \t  ").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id(" \n  ").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id(" \r  ").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id(" \f  ").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id(" \s  ").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id("a").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id("a ").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id("a  ").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id(" a  ").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id("  a  ").build(), 0));
    }


    @ParameterizedTest
    @MethodSource("testDataDefaultGroup")
    public void testDefaultGroup(DefaultGroupEntity input, int expected) {

        assertThat(validator.validate(input).size()).withFailMessage("string value: -" + input.getId() + "-")
                .isGreaterThanOrEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testDataCustomGroup")
    public void testCustomGroup(CustomGroupEntity input, int expected) {

        assertThat(validator.validate(input, CustomGroup.class).size())
                .withFailMessage("string value: -" + input.getId() + "-").isGreaterThanOrEqualTo(expected);
    }

    @Test
    public void testDefaultErrorMessage() {
        DefaultErrorMessageEntity input = DefaultErrorMessageEntity.builder().id("").build();
        Set<ConstraintViolation<DefaultErrorMessageEntity>> result = validator.validate(input);
        assertThat(result.size()).isEqualTo(1);

        String message = result.stream().findFirst().get().getMessage();
        String expected = String.format("{%s}", TrimmedNotBlank.class.getName());

        assertThat(message)
            .withFailMessage(String.format("result: %s; \nexpected: %s", message, expected))
            .isEqualTo(expected);
    }

    @Test
    public void testCustomErrorMessage() {
        CustomErrorMessageEntity input = CustomErrorMessageEntity.builder().id("").build();
        Set<ConstraintViolation<CustomErrorMessageEntity>> result = validator.validate(input);
        assertThat(result.size()).isEqualTo(1);

        String message = result.stream().findFirst().get().getMessage();
        String expected = "Custom Error Message";

        assertThat(message)
            .withFailMessage(String.format("result: %s; \nexpected: %s", message, expected))
            .isEqualTo(expected);
    }
}
