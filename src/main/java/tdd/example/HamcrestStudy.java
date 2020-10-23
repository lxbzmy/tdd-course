package tdd.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import tdd.domain.Account;
import tdd.example.HelloController;
import tdd.example.UserController;
import tdd.example.UserService;

import static org.hamcrest.Matchers.*;

public class HamcrestStudy {

  @Test
  void assertion_show_case() throws Exception {
    Account account = new Account("root");
  }

  @Test
  void response_contains_success() throws Exception {
    HelloController sut = new HelloController();
    String response = sut.hello("success");
  }
  
  @Test
  void 集合size大于1() throws Exception {
    UserService userService = new UserService();
    List<Account> list = userService.findAll();
    
  }

  @Test
  void 集合对象顺序为张三李四() throws Exception {
    UserService userService = new UserService();
    List<Account> list = userService.findAll();
    
  }

  @Test
  void 验证Map含有username等于张三() throws Exception {
    UserController sut = new UserController();
    Map<String, Object> result = sut.login("root","root");
    
  }
}
