package com.andrascsanyi.beanvalidationextensions.longasstringmustbegreaterorequaltoone;

import com.andrascsanyi.beanvalidationextensions.BeanValidationExtensionsApplicationTests;
import com.andrascsanyi.beanvalidationextensions.LongAsStringMustBeGreaterOrEqualToOne;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintViolationCreationContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Set;
import java.util.stream.Stream;
import jakarta.validation.ConstraintViolation;
import static org.assertj.core.api.Assertions.assertThat;

public class LongAsStringMustBeGreaterOrEqualToOneTests extends BeanValidationExtensionsApplicationTests {

    public static Stream<Arguments> testDefaultGroupData() {
        return Stream.of(Arguments.of(DefaultGroupEntity.builder().id("0").build(), 1),
                Arguments.of(DefaultGroupEntity.builder().id("1").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id(null).build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id("").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id(" ").build(), 0),
                Arguments.of(DefaultGroupEntity.builder().id("-1").build(), 1));
    }

    public static Stream<Arguments> testCustomGroupData() {
        return Stream.of(Arguments.of(CustomGroupEntity.builder().id("0").build(), 1),
                Arguments.of(CustomGroupEntity.builder().id("1").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id(null).build(), 0),
                Arguments.of(CustomGroupEntity.builder().id("").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id(" ").build(), 0),
                Arguments.of(CustomGroupEntity.builder().id("-1").build(), 1));
    }

    @ParameterizedTest
    @MethodSource("testDefaultGroupData")
    public void testDefaultGroup(DefaultGroupEntity e, long expected) {

        assertThat(validator.validate(e).size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testCustomGroupData")
    public void testCustomGroup(CustomGroupEntity e, long expected) {

        assertThat(validator.validate(e, CustomGroup.class).size()).isEqualTo(expected);
    }

    @Test
    public void testDefaultErrorMessage() {
        DefaultErrorMessageEntity entity = DefaultErrorMessageEntity.builder().id("0").build();

        Set<ConstraintViolation<DefaultErrorMessageEntity>> validationResult = validator.validate(entity);
        assertThat(validationResult.size()).isGreaterThan(0);

        String resultMessage = validationResult.stream().findFirst().get().getMessage();
        String expectedMessage = String.format("{%s}", LongAsStringMustBeGreaterOrEqualToOne.class.getName());

        assertThat(resultMessage.equals(expectedMessage))
                .withFailMessage(String.format("result: %s; \n expected %s", resultMessage, expectedMessage)).isTrue();
    }

    @Test
    public void testCustomErrorMessage() {
        CustomErrorMessageEntity entity = CustomErrorMessageEntity.builder().id("0").build();

        Set<ConstraintViolation<CustomErrorMessageEntity>> validationResult = validator.validate(entity);
        assertThat(validationResult.size()).isGreaterThan(0);

        String resultMessage = validationResult.stream().findFirst().get().getMessage();
        String expectedMessage = "Custom Error Message";

        assertThat(resultMessage.equals(expectedMessage))
                .withFailMessage(String.format("result: %s; \n expected %s", resultMessage, expectedMessage)).isTrue();
    }

}
