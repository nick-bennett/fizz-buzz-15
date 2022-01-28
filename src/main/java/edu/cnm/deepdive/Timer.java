package edu.cnm.deepdive;

public class Timer {

  private static final int DEFAULT_LIMIT = Integer.MAX_VALUE;

  public static void main(String[] args) {
    int limit = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_LIMIT;
    FizzBuzz fb = new FizzBuzz();
    long start = System.currentTimeMillis();
    fb.iterate(limit, fb::check, (value, state) -> { /* Do nothing. */});
    long duration = System.currentTimeMillis() - start;
    System.out.printf("%,d iterations in %d milliseconds = %.9f ms/iteration%n",
        limit, duration, (double) duration / limit);
  }

}
