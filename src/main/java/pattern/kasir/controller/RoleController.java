package pattern.kasir.controller;

import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pattern.kasir.dto.validation.RoleDTO;
import pattern.kasir.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping
  public String getAll() {
    return "Get All Roles";
  }

  // @PostMapping
  // public String create() {
  //   return "Create Role";
  // }

  @PostMapping
  public ResponseEntity<Object> createRole(
    @RequestBody @Valid RoleDTO roleDTO
  ) {
    return roleService.save(roleDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateRole(
    @PathVariable UUID id,
    @RequestBody @Valid RoleDTO roleDTO
  ) {
    return roleService.update(id, roleDTO);
  }
}
