package tdd.case4

import spock.lang.Issue
import spock.lang.Specification
import spock.lang.Title

@Title("Stack数据结构测试")
class StackTest2 extends Specification {

  void 空栈size是0() {
    when: '一个全新的栈'
    def stack = new Stack();
    then: '栈长是0'
    stack.size() == 0;
  }

  @Issue("TDD-1")
  def 入栈后size增加1() {
    given: "一个空栈"
    def stack = new Stack();
    when: "push一个元素"
    stack.push("🐶")
    then: "size增加1"
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
