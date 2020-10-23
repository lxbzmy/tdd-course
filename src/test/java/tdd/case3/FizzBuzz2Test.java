package tdd.case3;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FizzBuzz2Test {

  FizzBuzz2 sut = new FizzBuzz2();

  @Test
  void when_1_then_1() throws Exception {
    assertThat(sut.fizzBuzz(1), is("1"));
  }

  @Test
  void _3_then_fizz() throws Exception {
    assertThat(sut.fizzBuzz(3), is("Fizz"));
  }

  @Test
  void _5_then_buzz() throws Exception {
    assertThat(sut.fizzBuzz(5), is("Buzz"));
  }

  @Test
  void _15_then_fizzbuzz() throws Exception {
    assertThat(sut.fizzBuzz(15), is("FizzBuzz"));
  }
}
