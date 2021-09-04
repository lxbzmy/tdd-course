package tdd.case5

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title
import tdd.case3.FizzBuzz2

/**
 * <pre>
 * 功能：输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3. 如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * </pre>
 */
@Title("FizzBuzz验证")
class FizzBuzzTest2 extends Specification {
  @Subject
  FizzBuzz2 sut = new FizzBuzz2();

  void 正常情况输出数字本身() {
    expect:
    sut.fizzBuzz(1) == '1';
  }

  void "如果 n 同时是3和5的倍数，输出 “FizzBuzz”"() {
    expect:
    sut.fizzBuzz(15) == "FizzBuzz";
  }

  void "如果 n 是3的倍数，输出“Fizz”"() {
    expect:
    sut.fizzBuzz(3) == "Fizz";
  }

  void "如果 n 是5的倍数，输出“Buzz”"() {
    expect:
    sut.fizzBuzz(5) == "Buzz";
  }
}
