package tdd.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tdd.domain.Account;

public class AssertStudyCase {

  UserController c;
  UserService s;

  ObjectMapper mapper = new ObjectMapper();

  public AssertStudyCase() {
    s = new UserService();
    c = new UserController();
    c.service = s;
  }

  public String hello() {
    return "hello world";
  }

  public List<Account> queryAccount() {
    return s.findAll();
  }

  public String accountComment() {
    try {
      return mapper.writeValueAsString(new Account("张三"));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Account> orderAccountByName() {
    return s.findAll();
  }

  public Map<String, Object> queryAccountAsMap() {
    return c.login("root", "root");
  }

}
