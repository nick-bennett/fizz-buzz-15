package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.cnm.deepdive.FizzBuzz.State;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {


  static final int[] fizzValues = {3, 9, 18, 42};
  static final int[] buzzValues = {5, 25, 40, 95};
  static final int[] fizzBuzzValues = {15, 90, 105};
  static final int[] neitherValues = {4, 29, 31, 101};

  @Test
  void check_fizz() {
    FizzBuzz fb = new FizzBuzz();
    for (int value : fizzValues) {
      assertEquals(State.FIZZ, fb.check(value));
    }
  }

  @Test
  void check_buzz() {
    FizzBuzz fb = new FizzBuzz();
    for (int value : buzzValues) {
      assertEquals(State.BUZZ, fb.check(value));
    }
  }

  @Test
  void check_fizzBuzz() {
    FizzBuzz fb = new FizzBuzz();
    for (int value : fizzBuzzValues) {
      assertEquals(State.FIZZ_BUZZ, fb.check(value));
    }
  }

  @Test
  void check_neither() {
    FizzBuzz fb = new FizzBuzz();
    for (int value : neitherValues) {
      assertEquals(State.NEITHER, fb.check(value));
    }
  }

}