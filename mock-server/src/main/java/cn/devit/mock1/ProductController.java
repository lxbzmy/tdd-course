package cn.devit.mock1;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

  @GetMapping(value = "_search")
  public Object search(
      @RequestParam(value = "page", defaultValue = "1") int page) {
    if (page == 1) {
      return new ModelMap()
          .addAttribute("page", 1)
          .addAttribute("total", 4)
          .addAttribute("content",
              Arrays.asList(new Named("张三"), new Named("李四")));
    } else if (page == 2) {
      return new ModelMap()
          .addAttribute("page", 2)
          .addAttribute("total", 4)
          .addAttribute("content",
              Arrays.asList(new Named("王五"), new Named("马六")));
    }
    throw new IllegalArgumentException();
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public void e() {

  }

  static class Named {
    public String name;

    public Named(String s) {
      this.name = s;
    }
  }

}
