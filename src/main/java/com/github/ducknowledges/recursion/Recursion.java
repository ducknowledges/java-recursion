package com.github.ducknowledges.recursion;

import java.util.List;

public class Recursion {

  private Recursion() {}

  public static int recursionPow(int base, int power) {
    if (power == 0) {
      return 1;
    }
    return base * recursionPow(base, power - 1);
  }

  public static int recursionSumOfDigits(int number) {
    if (number == 0) {
      return 0;
    }
    return number % 10 + recursionSumOfDigits(number / 10);
  }

  public static int recursionLengthCount(List<?> list) {
    if (list.isEmpty()) {
      return 0;
    }
    list.remove(0);
    return 1 + recursionLengthCount(list);
  }
}
