package com.github.ducknowledges.recursion;

public class Recursion {

  private Recursion() {}

  public static int recursionPow(int base, int power) {
    if (power == 0) {
      return 1;
    }
    return base * recursionPow(base, power - 1);
  }
}
