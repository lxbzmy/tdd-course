package cn.devit.mock1;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public Object get() {
    return new ModelMap().addAttribute("hello","world");
  }
}
