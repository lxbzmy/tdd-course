package tdd.case2;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzz1Test {

  @Test
  void fizz_buzz() throws Exception {
    FizzBuzz1 fizzBuzz = new FizzBuzz1();
    fizzBuzz.fizzBuzz(15);
    assertThat(sb.toString(), is("1\n" +
        "2\nFizz\n4\nBuzz\nFizz\n" +
        "7\n8\n" +
        "Fizz\nBuzz\n" +
        "11\nFizz\n" +
        "13\n14\n" +
        "FizBuzz\n"));
  }

  StringBuilder sb = new StringBuilder();
  PrintStream origin;

  @BeforeEach
  public void wrap_out() {
    origin = System.out;
    PrintStream s = new PrintStream(System.out) {
      public void println(int x) {
        sb.append(x).append('\n');
      };

      public void println(String x) {
        sb.append(x).append('\n');
      };
    };
    System.setOut(s);
  }

  @AfterEach
  public void unwrap() {
    System.setOut(origin);
  }
}
