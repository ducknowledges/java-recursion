package com.github.ducknowledges.recursion;

import java.util.List;

public class Recursion {

  private Recursion() {}

  public static int recursivePow(int base, int power) {
    if (power == 0) {
      return 1;
    }
    return base * recursivePow(base, power - 1);
  }

  public static int recursiveSumOfDigits(int number) {
    if (number == 0) {
      return 0;
    }
    return number % 10 + recursiveSumOfDigits(number / 10);
  }

  public static int recursiveLengthCount(List<?> list) {
    if (list.isEmpty()) {
      return 0;
    }
    list.remove(0);
    return 1 + recursiveLengthCount(list);
  }

  public static boolean recursiveIsPalindrome(String string) {
    int strLength = string.length();
    if (strLength <= 1) {
      return true;
    }
    if (string.charAt(0) != string.charAt(strLength - 1)) {
      return false;
    }
    return recursiveIsPalindrome(string.substring(1, strLength - 1));
  }
}
