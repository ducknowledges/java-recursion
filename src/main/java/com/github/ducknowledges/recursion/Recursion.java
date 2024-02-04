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

  public static void recursivePrintEvenNumbers(List<Integer> numbers) {
    printEvenNumbers(numbers, 0);
  }

  private static void printEvenNumbers(List<Integer> numbers, int numberIndex) {
    if (numberIndex >= numbers.size()) return;
    Integer number = numbers.get(numberIndex);
    if (number % 2 == 0) {
      System.out.print(number);
    }
    printEvenNumbers(numbers, numberIndex + 1);
  }

  public static void recursivePrintEvenIndexes(List<?> list) {
    printEvenIndexes(list.size(), 0);
  }

  private static void printEvenIndexes(int listSize, Integer listIndex) {
    if (listIndex >= listSize) return;
    if (listIndex % 2 == 0) {
      System.out.print(listIndex);
    }
    printEvenIndexes(listSize, listIndex + 1);
  }
}
