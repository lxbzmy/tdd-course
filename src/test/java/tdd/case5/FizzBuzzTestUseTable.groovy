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
class FizzBuzzTestUseTable extends Specification {
  @Subject
  FizzBuzz2 sut = new FizzBuzz2();

  void FizzBuzz验证() {
    given:
    FizzBuzz2 sut = new FizzBuzz2();
    when:
    String r = sut.fizzBuzz(number);
    then:
    r == expect;
    where:
    number || expect
    1      || "1"
    2      || "2"
    3      || "Fizz"
    5      || "Buzz"
    7      || "7"
    9      || "Fizz"
    15     || "FizzBuzz"
  }

  void 一般情况是输出数字本身() {
    expect:
    r == number.toString();
    where:
    number << [1, 2, 4, 7]
  }

  void "3的倍数且不是5的倍数输出Fizz"() {
    expect:
    sut.fizzBuzz(number) == "Fizz"
    where:
    number << [3, 6, 9]
  }

  void "5的倍数且不是3的倍数输出Buzz"() {
    expect:
    sut.fizzBuzz(number) == "Buzz"
    where:
    number << [5, 10]
  }

  void "3的倍数且是5的倍数输出FizzBuzz"() {
    expect:
    sut.fizzBuzz(number) == "FizzBuzz"
    where:
    number << [15,30]
  }


}
