package pattern.kasir.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coba")
public class CobaController {

  @GetMapping
  public Integer getMethodName() {
    return 4;
  }
}
