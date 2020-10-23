package tdd.case1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest5 {

  Stack<Object> stack = new Stack<>();

  @Test
  void 空堆栈的size0() throws Exception {
    assertThat(stack.size(), is(0));
  }

  @Test
  void 放入一个对象后size加1() throws Exception {
    stack.push("🐶");
    assertThat(stack.size(), is(1));
  }

  @Test
  void pop一个对象后size减1() throws Exception {
    stack.push("🐶");
    stack.pop();
    assertThat(stack.size(), is(0));
  }

  @Test
  void 空栈pop报异常() throws Exception {
    assertThrows(EmptyStackException.class, () -> {
      stack.pop();
    });
  }
}
