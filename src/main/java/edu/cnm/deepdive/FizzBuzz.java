package edu.cnm.deepdive;

import java.util.function.Function;
import java.util.function.IntFunction;

public class FizzBuzz {

  public static final String FIZZ = "Fizz";
  public static final String BUZZ = "Buzz";
  public static final String FIZZ_BUZZ = "FizzBuzz";
  private static final int DEFAULT_LIMIT = 100;

  public static void main(String[] args) {
    int limit = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_LIMIT;
    FizzBuzz fb = new FizzBuzz();
    long duration;
    duration = fb.measure(limit, fb::checkBuilder);
    System.out.printf("%s: %,d iterations in %d milliseconds = %.6f ms/iteration%n",
        "Builder", limit, duration, (double) duration / limit);
    duration = fb.measure(limit, fb::checkSwitch);
    System.out.printf("%s: %,d iterations in %d milliseconds = %.6f ms/iteration%n",
        "Switch", limit, duration, (double) duration / limit);
    duration = fb.measure(limit, fb::checkNested);
    System.out.printf("%s: %,d iterations in %d milliseconds = %.6f ms/iteration%n",
        "Nested", limit, duration, (double) duration / limit);
    duration = fb.measure(limit, fb::checkLadder);
    System.out.printf("%s: %,d iterations in %d milliseconds = %.6f ms/iteration%n",
        "Ladder", limit, duration, (double) duration / limit);
  }

  private long measure(int limit, IntFunction<String> processor) {
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
    boolean divisibleBy3 = value % 3 == 0;
    boolean divisibleBy5 = value % 5 == 0;
    if (divisibleBy3) {
      if (divisibleBy5) {
        result = FIZZ_BUZZ;
      } else {
        result = FIZZ;
      }
    } else if (divisibleBy5) {
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

  public String checkSwitch(int value) {
    return switch (value % 15) {
      case 0 -> FIZZ_BUZZ;
      case 3, 6, 9, 12 -> FIZZ;
      case 5, 10 -> BUZZ;
      default -> String.valueOf(value);
    };
  }

}
