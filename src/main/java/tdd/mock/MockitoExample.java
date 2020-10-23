package tdd.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tdd.domain.Account;
import tdd.example.UserController;
import tdd.example.UserService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MockitoExample {

  @Mock
  UserService s;

  @InjectMocks
  UserController sut;
  
  @Test
  public void should_find_root() {
    Mockito.when(s.find("root")).thenReturn(new Account("root"));
    
    Account find = sut.findByUsername("root");
    
    assertThat(find.getUsername()).isEqualTo("root");
  }

}
