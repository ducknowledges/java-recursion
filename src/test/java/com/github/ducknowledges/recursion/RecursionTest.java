package com.github.ducknowledges.recursion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RecursionTest {

  @ParameterizedTest
  @CsvSource({"2, 0, 1", "2, 1, 2", "2, 2, 4", "2, 3, 8", "2, 4, 16"})
  @DisplayName("should return the correct number for recursion power calculation")
  void shouldCorrectlyRecusiveRaisedToThePower(int base, int power, int expected) {
    int actual = Recursion.recursionPow(base, power);

    assertThat(actual).isEqualTo(expected);
  }
}
