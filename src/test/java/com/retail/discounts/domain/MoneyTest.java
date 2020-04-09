package com.retail.discounts.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MoneyTest {

    @ParameterizedTest
    @MethodSource("percentageProvider")
    void percentage(Double input, Double percentage, Money expected) {
        // given
        Money money = Money.of(input);
        // when
        Money calculated = Money.percentage(money, percentage);
        // then
        assertEquals(expected, calculated, "Percentage function is not working");
    }

    static Stream<Arguments> percentageProvider() {
        return Stream.of(
            arguments(100d, 0.2, Money.of(20d)),
            arguments(100d, 0.5, Money.of(50d)),
            arguments(100d, 0.1, Money.of(10d))
        );
    }

    @ParameterizedTest
    @MethodSource("minusProvider")
    void minus(Money first, Money second, Money expected) {
        // when
        Money calculated = first.minus(second);
        // then
        assertEquals(expected, calculated, "Minus function is not working");
    }

    static Stream<Arguments> minusProvider() {
        return Stream.of(
            arguments(Money.of(10d), Money.of(10d), Money.of(0d)),
            arguments(Money.of(10d), Money.of(5d), Money.of(5d)),
            arguments(Money.of(50d), Money.of(5d), Money.of(45d))
        );
    }


    @ParameterizedTest
    @MethodSource("addProvider")
    void add(Money first, Money second, Money expected) {
        // when
        Money calculated = Money.add(first, second);
        // then
        assertEquals(expected, calculated, "Minus function is not working");
    }

    static Stream<Arguments> addProvider() {
        return Stream.of(
            arguments(Money.of(10d), Money.of(10d), Money.of(20d)),
            arguments(Money.of(10d), Money.of(5d), Money.of(15d)),
            arguments(Money.of(50d), Money.of(5d), Money.of(55d))
        );
    }
}