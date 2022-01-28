package edu.cnm.deepdive;

import edu.cnm.deepdive.FizzBuzz.State;

public class Printer {

  private static final int DEFAULT_LIMIT = 100;

  public static void main(String[] args) {
    int limit = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_LIMIT;
    FizzBuzz fb = new FizzBuzz();
    fb.iterate(limit, fb::check, Printer::print);
  }

  private static void print(int value, State state) {
    System.out.printf("%d: %s%n", value, state);
  }

}
