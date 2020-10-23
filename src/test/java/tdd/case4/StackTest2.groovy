package tdd.case4

import spock.lang.Specification

class StackTest2 extends Specification {

  void 空栈size是0() {
    when: '一个全新的栈'
    def stack = new Stack();
    then: '栈长是0'
    stack.size() == 0;
  }

  void 入栈后size增加1() {
    given:
    def stack = new Stack();
    when:
    stack.push("🐶")
    then:
    stack.size() == 1;
  }

  def 出栈后size减少1() {
    given:
    def stack = new Stack();
    when:
    stack.push("🐶")
    stack.pop()
    then:
    stack.size() == 0;
  }

  def 空栈pop报异常1() {
    given:
    def stack = new Stack();
    when:
    stack.pop()
    then:
    thrown(EmptyStackException)
  }

}
