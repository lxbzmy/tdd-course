package tdd.case2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(OutputCaptureExtension.class)
public class FizzBuzz1Test2 {

  @Test
  void fizz_buzz(CapturedOutput output) throws Exception {
    FizzBuzz1 fizzBuzz = new FizzBuzz1();
    fizzBuzz.fizzBuzz(15);

    assertThat(output.getOut(), is("1\n" +
        "2\nFizz\n4\nBuzz\nFizz\n" +
        "7\n8\n" +
        "Fizz\nBuzz\n" +
        "11\nFizz\n" +
        "13\n14\n" +
        "FizBuzz\n"));
  }

}
