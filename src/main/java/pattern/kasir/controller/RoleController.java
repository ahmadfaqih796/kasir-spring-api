package pattern.kasir.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

  @GetMapping
  public String getAll() {
    return "Get All Roles";
  }

  @PostMapping
  public String create() {
    return "Create Role";
  }
}
