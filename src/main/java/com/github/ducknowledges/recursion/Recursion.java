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
    printEvenIndexes(list, 0);
  }

  private static void printEvenIndexes(List<?> list, int listIndex) {
    if (listIndex >= list.size()) return;
    System.out.print(list.get(listIndex));
    printEvenIndexes(list, listIndex + 2);
  }

  public static int recursiveFindSecondMax(List<Integer> numbers) {
    int beginIndex = 0;
    return findSecondMax(numbers, numbers.get(beginIndex), numbers.get(beginIndex), beginIndex);
  }

  private static int findSecondMax(List<Integer> numbers, int prevMax, int currentMax, int numberIndex) {
    if (numberIndex >= numbers.size()) {
      return prevMax;
    }
    int currentNumber = numbers.get(numberIndex);
    if (currentNumber > currentMax) {
      prevMax = currentMax;
      currentMax = currentNumber;
    } else if (currentNumber > prevMax) {
      prevMax = currentNumber;
    }
    return findSecondMax(numbers, prevMax, currentMax, numberIndex + 1);
  }
}
