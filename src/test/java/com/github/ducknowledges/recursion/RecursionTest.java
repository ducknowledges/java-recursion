package com.github.ducknowledges.recursion;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

  @ParameterizedTest
  @CsvSource({"1234567, 246", "888, 888", "585, 8"})
  @DisplayName("printEvenNumbers should print recursive even numbers")
  void shouldCorrectlyRecursivePrintEvenNumbers(String numbers, String expectedEvenNumbers) {
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));
    List<Integer> referenceList = Arrays.stream(numbers.split("")).map(Integer::parseInt).toList();

    Recursion.recursivePrintEvenNumbers(referenceList);
    String printedEvenNumbers = outputStreamCaptor.toString();

    assertThat(printedEvenNumbers).isEqualTo(expectedEvenNumbers);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "1357"})
  @DisplayName("printEvenNumbers should print empty string")
  void shouldCorrectlyRecursivePrintEmptyString(String numbers) {
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));
    List<Integer> referenceList =
        numbers.isEmpty()
            ? List.of()
            : Arrays.stream(numbers.split("")).map(Integer::parseInt).toList();

    Recursion.recursivePrintEvenNumbers(referenceList);
    String printedEvenNumbers = outputStreamCaptor.toString();

    assertThat(printedEvenNumbers).isEmpty();
  }

  @Test
  @DisplayName("should print recursive list elements with even index")
  void shouldCorrectlyRecursivePrintEvenIndexesOfList() {
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));
    List<?> referenceList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
    String expectedEvenIndexes = "02468";

    Recursion.recursivePrintEvenIndexes(referenceList);
    String printedEvenIndexes = outputStreamCaptor.toString();

    assertThat(printedEvenIndexes).isEqualTo(expectedEvenIndexes);
  }

  @Test
  @DisplayName("recursivePrintEvenIndexes should print empty string")
  void shouldCorrectlyRecursivePrintEmptyIndexes() {
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));
    List<Integer> referenceList = List.of();

    Recursion.recursivePrintEvenIndexes(referenceList);
    String printedEvenIndexes = outputStreamCaptor.toString();

    assertThat(printedEvenIndexes).isEmpty();
  }

  @ParameterizedTest
  @CsvSource({"54321, 4", "12, 1", "25435, 5", "3254, 4", "123111, 2", "2222, 2", "889910, 9"})
  @DisplayName("should recursive find second max value in list of numbers")
  void shouldFindSecondMaxInNumbers(String numbersStr, int expected) {
    List<Integer> numbers = Arrays.stream(numbersStr.split("")).map(Integer::parseInt).toList();
    int actual = Recursion.recursiveFindSecondMax(numbers);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  @DisplayName("should recursive list files in directory and subdirectories")
  void shouldRecusiveListFiles() throws IOException {
    Path tempDir = Files.createTempDirectory("testDir");
    Path subDir = Files.createTempDirectory(tempDir, "subDir");
    Path emptySubDir = Files.createTempDirectory(tempDir, "emptySubDir");
    Path subSubDir = Files.createTempDirectory(subDir, "subSubDir");
    Path file1 = Files.createTempFile(tempDir, "testFile1", ".txt");
    Path file2 = Files.createTempFile(tempDir, "testFile2", ".txt");
    Path file3 = Files.createTempFile(subDir, "testFile3", ".txt");
    Path file4 = Files.createTempFile(subDir, "testFile4", ".txt");
    Path file5 = Files.createTempFile(subSubDir, "testFile5", ".txt");

    List<File> fileList = Recursion.recursiveListFiles(tempDir.toString());

    assertThat(fileList)
        .hasSize(5)
        .contains(file1.toFile(), file2.toFile(), file3.toFile(), file4.toFile(), file5.toFile());

    Files.deleteIfExists(file1);
    Files.deleteIfExists(file2);
    Files.deleteIfExists(file3);
    Files.deleteIfExists(file4);
    Files.deleteIfExists(file5);
    Files.deleteIfExists(subSubDir);
    Files.deleteIfExists(subDir);
    Files.deleteIfExists(emptySubDir);
    Files.deleteIfExists(tempDir);
  }

  @Test
  @DisplayName("should recursive list empty files in empty directory")
  void shouldRecusiveListEmptyFiles() throws IOException {
    Path tempDir = Files.createTempDirectory("testDir");

    List<File> fileList = Recursion.recursiveListFiles(tempDir.toString());

    assertThat(fileList).isEmpty();

    Files.deleteIfExists(tempDir);
  }
}
