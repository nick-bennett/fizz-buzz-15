package edu.cnm.deepdive;

import java.util.function.BiConsumer;
import java.util.function.IntFunction;

public class FizzBuzz {

  public void iterate(
      int limit, IntFunction<State> processor, BiConsumer<Integer, State> consumer) {
    for (int i = 0; i < limit; i++) {
      int value = i + 1;
      consumer.accept(value, processor.apply(value));
    }
  }

  public State check(int value) {
    State state;
    boolean divisibleBy3 = (value % 3 == 0);
    boolean divisibleBy5 = (value % 5 == 0);
    if (divisibleBy3 && divisibleBy5) {
      state = State.FIZZ_BUZZ;
    } else if (divisibleBy3) {
      state = State.FIZZ;
    } else if (divisibleBy5) {
      state = State.BUZZ;
    } else {
      state = State.NEITHER;
    }
    return state;
  }

  public enum State {
    FIZZ, BUZZ, FIZZ_BUZZ, NEITHER;
  }

}
