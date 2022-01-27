package edu.cnm.deepdive;

public class FizzBuzz {

  public static final String FIZZ = "Fizz";
  public static final String BUZZ = "Buzz";
  public static final String FIZZ_BUZZ = "FizzBuzz";
  private static final int DEFAULT_LIMIT = 100;

  public static void main(String[] args) {
    int limit = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_LIMIT;
    FizzBuzz fb = new FizzBuzz();
    for (int i = 1; i <= limit; i++) {
      System.out.println(fb.check(i));
    }
  }

  public String check(int value) {
    return switch (value % 15) {
      case 0 -> FIZZ_BUZZ;
      case 3, 6, 9, 12 -> FIZZ;
      case 5, 10 -> BUZZ;
      default -> String.valueOf(value);
    };
  }

}
