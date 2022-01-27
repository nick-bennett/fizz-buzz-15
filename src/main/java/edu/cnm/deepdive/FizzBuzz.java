package edu.cnm.deepdive;

import java.util.function.Function;

public class FizzBuzz {

  public static final String FIZZ = "Fizz";
  public static final String BUZZ = "Buzz";
  public static final String FIZZ_BUZZ = "FizzBuzz";
  private static final int DEFAULT_LIMIT = 100;

  public static void main(String[] args) {
    int limit = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_LIMIT;
    FizzBuzz fb = new FizzBuzz();
    long duration = fb.measure(limit, fb::checkLadder);
    System.out.printf("%s: %,d iterations in %d milliseconds = %.6f ms/iteration%n",
        "Ladder", limit, duration, (double) duration / limit);
    duration = fb.measure(limit, fb::checkNested);
    System.out.printf("%s: %,d iterations in %d milliseconds = %.6f ms/iteration%n",
        "Nested", limit, duration, (double) duration / limit);    duration = fb.measure(limit, fb::checkBuilder);
    System.out.printf("%s: %,d iterations in %d milliseconds = %.6f ms/iteration%n",
        "Builder", limit, duration, (double) duration / limit);
  }

  private long measure(int limit, Function<Integer, String> processor) {
    long start = System.currentTimeMillis();
    for (int i = 1; i <= limit; i++) {
      processor.apply(i);
    }
    return System.currentTimeMillis() - start;
  }

  public String checkLadder(int value) {
    String result;
    boolean divisibleBy3 = value % 3 == 0;
    boolean divisibleBy5 = value % 5 == 0;
    if (divisibleBy3 && divisibleBy5) {
      result = FIZZ_BUZZ;
    } else if (divisibleBy3) {
      result = FIZZ;
    } else if (divisibleBy5) {
      result = BUZZ;
    } else {
      result = String.valueOf(value);
    }
    return result;
  }

  public String checkNested(int value) {
    String result;
    if (value % 3 == 0) {
      if (value % 5 == 0) {
        result = FIZZ_BUZZ;
      } else {
        result = FIZZ;
      }
    } else if (value % 5 == 0) {
      result = BUZZ;
    } else {
      result = String.valueOf(value);
    }
    return result;
  }

  public String checkBuilder(int value) {
    StringBuilder buffer = new StringBuilder(10);
    if (value % 3 == 0) {
      buffer.append(FIZZ);
    }
    if (value % 5 == 0) {
      buffer.append(BUZZ);
    }
    if (buffer.isEmpty()) {
      buffer.append(value);
    }
    return buffer.toString();
  }

}
