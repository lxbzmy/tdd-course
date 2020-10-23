package tdd.mock

import spock.lang.Specification
import tdd.example.UserController
import tdd.example.UserService

class MockWithSpock extends Specification {

  def login_ok() {
    given:
    UserController sut = new UserController();
    and:
    UserService service = Mock()
    sut.service = service;
    1 * service.passwordCheck("any", "***") >> true
    when:
    def result = sut.login("any", "***");
    then:
    result.success == true

  }
}
