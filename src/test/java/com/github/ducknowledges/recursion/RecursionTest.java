package com.github.ducknowledges.recursion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RecursionTest {

  @ParameterizedTest
  @CsvSource({"2, 0, 1", "2, 1, 2", "2, 2, 4", "2, 3, 8", "2, 4, 16"})
  @DisplayName("should return the correct number for recursion power calculation")
  void shouldCorrectlyRecusiveRaisedToThePower(int base, int power, int expected) {
    int actual = Recursion.recursivePow(base, power);

    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({"0, 0", "1, 1", "12, 3", "123, 6", "321, 6"})
  @DisplayName("should return the correct number of recursive sum of digits")
  void shouldCorrectlyRecursiveSumOfDigits(int number, int expected) {
    int actual = Recursion.recursiveSumOfDigits(number);

    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "1,2", "1,2,3,4,5,6"})
  @DisplayName("should return recursive count list size")
  void shouldCorrectlyRecursiveCountListSize(String string) {
    List<String> referenceList = Arrays.stream(string.split(",")).toList();
    List<String> list = new ArrayList<>(referenceList);
    int actual = Recursion.recursiveLengthCount(list);

    assertThat(actual).isEqualTo(referenceList.size());
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "a", "abba", "abcba"})
  @DisplayName("should return True if string is palindrome")
  void shouldRecursiveCheckWhenStringIsPalindrome(String string) {
    boolean actual = Recursion.recursiveIsPalindrome(string);

    assertThat(actual).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"ab", "abc", "abca", "aacaaa", "abxdedcba"})
  @DisplayName("should return False if string is not palindrome")
  void shouldRecursiveCheckWhenStringIsNotPalindrome(String string) {
    boolean actual = Recursion.recursiveIsPalindrome(string);

    assertThat(actual).isFalse();
  }
}
