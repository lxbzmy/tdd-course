package tdd.case4

import spock.lang.Specification

class StackTest3 extends Specification {

  def stack = new Stack();

  void 空栈size是0() {
    expect: '栈长度加1'
    stack.size() == 0;
  }

  def 出栈入栈() {
    when:
    stack.push("🐶")
    then: "入栈后size增加1"
    stack.size() == old(stack.size()) + 1;
    when:
    stack.pop()
    then: "出栈后size减1"
    stack.size() == old(stack.size()) - 1;
    when:
    stack.pop()
    then: '空栈pop报异常'
    thrown(EmptyStackException)
  }

}
